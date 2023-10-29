package analizadoeLexico;

import tablaSimbolos.*;
import java.io.IOException;
import java.util.Hashtable;

public class AnalizadorLexico {

    public static int linea = 1; //Cuenta las lineas de entrada
    public char preanalisis = ' '; //Contiene el siguiente carácter de entrada

    //Acá se almacenan las palabras reservadas
    private Hashtable palabras = new Hashtable();

    void reservar(Palabra token) {
        palabras.put(token.lexema, token);
    }

    //Agregamos e inicializamos las palabras reservadas
    public AnalizadorLexico() {
        reservar(new Palabra("if", Etiqueta.IF));
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(Palabra.True);
        reservar(Palabra.False);
        reservar(Tipo.Int);
        reservar(Tipo.Char);
        reservar(Tipo.Bool);
        reservar(Tipo.Float);

    }

    //Utiliamos esta funcion para leer el siguiente carácter de entrada y colocarlo en la variable preanalisis
    void readch() throws IOException {
        preanalisis = (char) System.in.read();
    }

    //sobrecargamos el metodo para reconocer los tokens compuestos
    boolean readch(char c) throws IOException {
        readch();
        if (preanalisis != c) {
            return false;
        }
        preanalisis = ' ';
        return true;
    }

    /* Omitimos los caracteres de espacio en blanco, tabuladores y de nueva línea
       Reconoce los Tokens compuestos
       Reconoce los numeros enteros y decimales
     */
    public Token explorar() throws IOException {
        for (;; readch()) {
            if (preanalisis == ' ' || preanalisis == '\t') {
                continue;
            } else if (preanalisis == '\n') {
                linea = linea + 1;
            } else {
                break;
            }
        }

        switch (preanalisis) {
            case '&':
                if (readch('&')) {
                    return Palabra.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Palabra.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Palabra.eq;
                } else {
                    return new Token('=');
                }
            case '!':
                if (readch('!')) {
                    return Palabra.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('<')) {
                    return Palabra.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('>')) {
                    return Palabra.ge;
                } else {
                    return new Token('>');
                }

        }

        if (Character.isDigit(preanalisis)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(preanalisis, 10);
                readch();

            } while (Character.isDigit(preanalisis));
            
            if (preanalisis != '.') {
                return new Numero(v);
            }
            
            float x = v; 
            float d = 10;
            
            for (;;) {
                readch();
                if (!Character.isDigit(preanalisis)) {
                    break;
                }
                x = x + Character.digit(preanalisis, 10) / d; 
                d = d*10;
            }
            return new Real(x);
        }

        //Analizamos las palabras reservadas e identificadores
        if (Character.isLetter(preanalisis)) {
            StringBuffer buffer = new StringBuffer();
            do {
                buffer.append(preanalisis);
                readch();
            } while (Character.isLetterOrDigit(preanalisis));
            String s = buffer.toString();
            Palabra word = (Palabra) palabras.get(s);
            if (word != null) {
                return word;
            }
            word = new Palabra(s, Etiqueta.ID);
            palabras.put(s, word);
            return word;
        }

        Token t = new Token(preanalisis);
        preanalisis = ' ';
        return t;
    }
}

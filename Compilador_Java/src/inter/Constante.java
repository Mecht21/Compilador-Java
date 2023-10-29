package inter;

import analizadoeLexico.*;
import tablaSimbolos.*;

public class Constante extends Expr {

    //Construye una hoja en el árbol sintáctico con la etiqueta tok y el tipo p
    public Constante(Token tok, Tipo p) {
        super(tok, p);
    }

    //Crear un objeto constante a partir de un entero.
    public Constante(int i) {
        super(new Numero(i), Tipo.Int);
    }
    public static final Constante True = new Constante(Palabra.True, Tipo.Bool),
            False = new Constante(Palabra.False, Tipo.Bool);

    public void salto(int t, int f) {
        if (this == True && t != 0) {
            emitir("goto L" + t);
        } else if (this == False && f != 0) {
            emitir("goto L" + f);
        }
    }
}

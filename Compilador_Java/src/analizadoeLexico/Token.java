package analizadoeLexico;

public class Token {

    public final int etiqueta;

    //Constructor para crear Tokens
    public Token(int token) {
        etiqueta = token;
    }
    
    public String toString(){
        return "" + (char) etiqueta;
    }
}

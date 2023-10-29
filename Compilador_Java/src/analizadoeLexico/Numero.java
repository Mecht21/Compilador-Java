package analizadoeLexico;

public class Numero extends Token {

    public final int valor;

    //Establecemos la etiqueta
    public Numero(int v) {
        super(Etiqueta.NUM);
        valor = v;
    }
    
    public String toString() {
        return "" + valor;
    }
}

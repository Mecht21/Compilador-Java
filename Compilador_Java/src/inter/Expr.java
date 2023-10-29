package inter;

import analizadoeLexico.*;
import tablaSimbolos.*;

public class Expr extends Nodo {

    public Token op;
    public Tipo tipo;

    public Expr(Token tok, Tipo p) {
        op = tok;
        tipo = p;
    }

    //Devuelve un “término” que puede caber del lado derecho de una instrucción de tres direcciones
    public Expr gen() {
        return this;
    }

    //calcula o “reduce” una expresión hasta una sola dirección;
    public Expr reducir() {
        return this;
    }

    public void salto(int t, int f) {
        emitirsaltos(toString(), t, f);
    }

    public void emitirsaltos(String prueba, int t, int f) {

        if (t != 0 && f != 0) {
            emitir("if " + prueba + " goto L" + t);
            emitir("goto L" + f);
        } else if (t != 0) {
            emitir("if " + prueba + " goto L" + t);
        } else if (f != 0) {
            emitir("iffalse " + prueba + " goto L" + f);
        } else ; // nada, ya que tanto t como f pasan directo

    }

    public String toString() {
        return op.toString();
    }
}

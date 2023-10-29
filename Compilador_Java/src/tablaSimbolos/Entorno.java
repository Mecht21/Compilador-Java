package tablaSimbolos;

import analizadoeLexico.*;
import inter.*;

import java.util.Hashtable;

public class Entorno {

    private Hashtable tabla;
    protected Entorno ent;

    public Entorno(Entorno n) {
        tabla = new Hashtable();
        ent = n;
    }

    //Almacenamos los tokens en la tabla de simbolos
    public void put(Token t, Id i) {
        tabla.put(t, i);
    }

    public Id get(Token t) {
        for (Entorno e = this; e != null; e = e.ent) {
            Id encontro = (Id) (e.tabla.get(t));
            if (encontro != null) {
                return encontro;
            }
        }
        return null;
    }
}

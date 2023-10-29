package tablaSimbolos;

import analizadoeLexico.*;

public class Arreglo extends Tipo {

    public Tipo de;
    public int tamanio = 1; // numero de elementos

    public Arreglo(int tm, Tipo p) {
        //stablece el campo anchura, que es esencial para los cálculos de direcciones
        super("[]", Etiqueta.INDEX, tm * p.anchura); 
        tamanio = tm;
        de = p;
    }

    public String toString() {
        return "[" + tamanio + "] " + de.toString();
    }
}

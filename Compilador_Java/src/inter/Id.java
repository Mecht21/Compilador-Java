package inter;

import analizadoeLexico.*;
import tablaSimbolos.*;

public class Id extends Expr {

    public int desplazamiento; // direccion relativa

    public Id(Palabra id, Tipo p, int b) {
        super(id, p);
        desplazamiento = b;
    }
}

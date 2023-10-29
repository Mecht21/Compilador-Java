package mainPackage;

import java.io.*;
import analizadoeLexico.*;
import analizador.*;

public class MainCompiler {

    public static void main(String[] args) throws IOException {
        AnalizadorLexico lex = new AnalizadorLexico();
        Analizador analizador = new Analizador(lex);
        analizador.programa();
        System.out.write('\n');
    }
}

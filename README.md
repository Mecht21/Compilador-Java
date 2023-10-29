# Compilador-Java

#Descripción: Un compilador moderno cuyo desarrollo fue basado en los principios y técnicas descritos en el clásico "Dragon Book" ("Compiladores: Principios, Técnicas y Herramientas"). Cabe recalcar

![Purple_dragon_book_b](https://github.com/Mecht21/Compilador-Java/assets/109832204/0d17e7de-db07-4b5e-90de-0ea1723ad9ba)

#Características
#Análisis Léxico

#    Reconocimiento de Tokens: Utiliza autómatas finitos determinísticos para reconocer patrones en el código fuente y traducirlos en tokens.
#    Manejo de Errores Léxicos: Identifica y reporta errores léxicos con mensajes claros, ayudando al desarrollador a corregir el código fuente.

#Análisis Sintáctico

#    Construcción del Árbol de Sintaxis: Utiliza técnicas de análisis descendente/ascendente para construir un árbol de sintaxis abstracta a partir de los tokens.
#    Manejo de Errores Sintácticos: Detecta y reporta errores de estructura y gramática en el código, proporcionando información relevante para su corrección.

#Semántica Estática

 #   Chequeo de Tipos: Realiza un chequeo de tipos riguroso para asegurar la coherencia y corrección del código.
 #   Gestión del Ambiente: Mantiene un registro de variables, funciones y sus ámbitos para garantizar que se usen de manera adecuada.
 #   Resolución de Nombres: Asegura que cada identificador utilizado tiene una definición clara en el código.

#Optimización

#    Eliminación de Código Inaccesible: Detecta y elimina segmentos de código que no afectan el comportamiento del programa.
#    Optimización de Bucles: Mejora la eficiencia de los bucles a través de técnicas como unrolling y hoisting.
#    Constant Folding: Evalúa expresiones constantes en tiempo de compilación para mejorar la eficiencia en tiempo de ejecución.

#Generación de Código

#    Traducción a Lenguaje Objetivo: Convierte el AST en código de un lenguaje objetivo específico (por ejemplo, LLVM, máquina virtual propia, binarios para una arquitectura específica).
#    Gestión de Memoria: Asigna y gestiona memoria para variables y estructuras de datos.
#    Manejo de Errores en Tiempo de Ejecución: Genera código que puede detectar y manejar errores durante la ejecución, como división por cero o acceso fuera de límites en arrays.

#Lenguaje Fuente

#Este compilador es para el lenguaje de Java.

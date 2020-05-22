package SpreadSheet;

import Value.MaybeValue;

import java.util.Set;

public interface Expression {

    /**
     * Añade el conjunto de celdas que poseen la expresion,
     * directa o indirectamente. Puede ser null.
     * Al ejecutarse, primero añade a su propio set, y
     * despues ejecuta push_references(), con el fin de
     * seguir actualizando la cadena.
     */
    Set<Cell> references();

    /**
     * Retorna el valor de la formula.
     */
    MaybeValue evaluate();
}

// Las clases deben de ser inmutables..
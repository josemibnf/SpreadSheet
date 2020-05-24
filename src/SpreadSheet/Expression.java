package SpreadSheet;

import Expression.MaybeValue;

import java.util.Set;

public interface Expression {

    /**
     * Retorna el valor de la formula.
     */
    MaybeValue evaluate();

    /**
     * Añade el conjunto de celdas que poseen la expresion,
     * directa o indirectamente.
     */
    Set<Cell> references();

}

// Las clases deben de ser inmutables
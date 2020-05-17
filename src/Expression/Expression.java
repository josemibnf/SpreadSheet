package Expression;

import SpreadSheet.Cell;
import Value.MaybeValue;

import java.util.Set;

public interface Expression {

    /**
     * Posee el conjunto de celdas que posee la expresion,
     * directa o indirectamente. Puede ser null.
     *
     * @return
     */
    Set<Cell> references();

    /**
     * Retorna el valor de la formula.
     *
     * @return
     */
    MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
package SpreadSheet;

import val.MaybeValue;

import java.util.Set;

public interface Expression {
    /**
     * Posee el conjunto de celdas que posee la expresion,
     * directa o indirectamente. Puede ser null.
     *
     * @return
     */
    public Set<Cell> references();

    /**
     * Retorna el valor de la formula.
     *
     * @return
     */
    public MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
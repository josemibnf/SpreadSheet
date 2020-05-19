package spreadsheet;

import java.util.Set;
import spreadsheet.value.MaybeValue;

public interface Expression {
    
    /**
     * Posee el conjunto de celdas que poseen la expresion,
     * directa o indirectamente. Puede ser null.
     */
    public void references(Set<Cell> refs);
    
    /**
     * Retorna el valor de la formula.
     * @return
     */
    public MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
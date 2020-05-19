package spreadsheet;

import java.util.Set;
import spreadsheet.value.MaybeValue;

public interface Expression {

	/**
     * Posee el conjunto de celdas que poseen la expresion,
     * directa o indirectamente. Puede ser null.
     */
    public void set_references(Set<Cell> refs);

    public Set<Cell> get_references();
    
    /**
     * Retorna el valor de la formula.
     * @return
     */
    public MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
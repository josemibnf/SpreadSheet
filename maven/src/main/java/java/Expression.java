package java;

import java.util.Set;
import java.value.MaybeValue;

public interface Expression {
    
    /**
     * Posee el conjunto de celdas que posee la expresion,
     * directa o indirectamente. Puede ser null.
     * @return
     */
    public Set<Cell> references(); 
    
    /**
     * Retorna el valor de la formula.
     * @return
     */
    public MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
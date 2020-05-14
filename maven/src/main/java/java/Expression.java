package java;

import java.Cell;
import java.opt.Operation;
import java.util.Set;
import java.value.MaybeValue;

public interface Expression {
    
    public Set<Cell> references;  // Posee el conjunto de celdas que posee
                                 // la expresion, directa o inderectamente,
                                // puede ser null.
    
    /**
     * Retorna el valor de la formula.
     * @return
     */
    public MaybeValue evaluate();
    public Set<Cell> getReferences();
}

// Las clases deben de ser inmutables.
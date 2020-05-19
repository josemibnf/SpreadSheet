package spreadsheet;

import java.util.Set;
import spreadsheet.value.MaybeValue;

public interface Expression {

	/**
     * Posee el conjunto de celdas que poseen la expresion,
     * directa o indirectamente. Puede ser null.
     */
    public void set_references(Set<Cell> refs);

    /**
     * Obtiene las referencias de la expresion.
     * @return
     */
    public Set<Cell> get_references();

    /**
     * Ejecuta set_references en las expresiones de las que depende.
     * 
     * Si se ejecutara en los constructores, al actualizar la formula
     * de una celda, primero ejecutariamos los sets a las dependencias
     * (con valor nulo), y despues añadiriamos las referencias de la 
     * formula anterior, lo cual seria bastante inutil.
     */
    public void push_references();
    
    /**
     * Retorna el valor de la formula.
     * @return
     */
    public MaybeValue evaluate();
}

// Las clases deben de ser inmutables.
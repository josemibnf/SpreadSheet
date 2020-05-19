package spreadsheet.value;

import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;

public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();
    public Set<Cell> refs;

    @Override
    public void set_references(Set<Cell> refs) {
        this.refs = refs;
        this.notify_references();
    }

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }    
    
    @Override
    public void push_references() {
        // No tiene a quien comunicar su existencia.
    }

    /**
     * Se ejecuta en el mismo momento que las otras
     * expresiones ejecutan push_references, 
     * pero en este caso, como hemos modificado un valor,
     * hacemos que todas las celdas de la cadena revaluen 
     * sus valores.
     * 
     */
    private void notify_references(){
        for (Cell c : this.refs){
            c.revaluate();
        }
    }
}

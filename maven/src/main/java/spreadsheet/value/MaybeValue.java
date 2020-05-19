package spreadsheet.value;

import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;

public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();
    public Set<Cell> refs;

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }    
    
    @Override
    public void push_references() {
        // No tiene a quien comunicar su existencia.
    }
    
}

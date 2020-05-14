package spreadsheet.value;

import spreadsheet.Cell;
import spreadsheet.Expression;
import java.util.HashSet;
import java.util.Set;

public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();

    @Override
    public Set<Cell> references() {
        return new HashSet<Cell>();
    }
    
}

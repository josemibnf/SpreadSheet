package val;

import SpreadSheet.Cell;
import SpreadSheet.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class MaybeValue implements Expression {

    public abstract boolean hasValue();

    @Override
    public Set<Cell> references() {
        return new HashSet<Cell>();
    }

}

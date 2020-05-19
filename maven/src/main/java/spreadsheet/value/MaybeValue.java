package spreadsheet.value;

import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;

public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();
}

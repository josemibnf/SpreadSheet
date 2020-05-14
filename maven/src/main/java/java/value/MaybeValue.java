package java.value;

import java.Cell;
import java.Expression;
import java.util.Set;

public abstract class MaybeValue implements Expression{

    public abstract boolean hasValue();

    @Override
    public Set<Cell> references() {
        return null;
    }
    
}

//si	considereu	els	MaybeValues	com	expressions,
// podreu	simplificar	una	mica	el	problema.	
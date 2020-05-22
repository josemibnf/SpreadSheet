package Value;

import SpreadSheet.Expression;

public abstract class MaybeValue implements Expression {
    private final boolean hasValue;

    public MaybeValue(boolean hasValue){
        this.hasValue = hasValue;
    }
    public boolean hasValue(){
        return hasValue;
    }
}

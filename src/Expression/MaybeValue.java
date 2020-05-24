package Expression;

import SpreadSheet.Expression;

public abstract class MaybeValue implements Expression {
    private final boolean HAS_VALUE;

    public MaybeValue(boolean hasValue) {
        this.HAS_VALUE = hasValue;
    }

    public boolean hasValue() {
        return HAS_VALUE;
    }
}

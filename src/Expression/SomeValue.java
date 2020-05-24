package Expression;

import SpreadSheet.Cell;

import java.util.HashSet;
import java.util.Set;

public class SomeValue extends MaybeValue {

    private final int VALUE;

    public SomeValue(int i) {
        super(true);
        this.VALUE = i;
    }

    public int getVALUE() {
        return this.VALUE;
    }


    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        SomeValue other = (SomeValue) obj;
        return this.VALUE == other.VALUE;
    }

}
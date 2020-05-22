package Value;

import SpreadSheet.Cell;

import java.util.HashSet;
import java.util.Set;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int i) {
        super(true);
        this.value = i;
    }

    public int getValue() {
        return this.value;
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
    public boolean equals(Object obj){
        if (getClass() != obj.getClass())
            return false;
        SomeValue sV = (SomeValue) obj;
        return this.value == sV.value;
    }

}
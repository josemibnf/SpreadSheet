package java.value;

import java.Cell;
import java.util.Set;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean hasValue() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public MaybeValue evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Cell> getReferences() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
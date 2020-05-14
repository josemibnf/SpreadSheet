package java;

import java.util.HashSet;
import java.util.Set;
import java.value.MaybeValue;

public class Reference implements Expression {
    private final Cell ref;

    public Reference(Cell ref) {
        this.ref = ref;
    }

    @Override
    public MaybeValue evaluate() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> set = new HashSet<Cell>();
        set.add(ref);
        return set;
    }
}
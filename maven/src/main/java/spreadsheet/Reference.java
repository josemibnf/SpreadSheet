package spreadsheet;

import java.util.Set;
import spreadsheet.value.MaybeValue;

public class Reference implements Expression {
    private final Cell ref;
    public Set<Cell> refs;

    public Reference(Cell ref) {
        this.ref = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return ref.evaluate();
    }

    @Override
    public void references(Set<Cell> refs) {
        this.refs = refs;
    }
}
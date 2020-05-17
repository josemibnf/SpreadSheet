import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {
    private final Cell ref;

    public Reference(Cell ref) {
        this.ref = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return ref.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> set = new HashSet<Cell>();
        set.add(ref);
        set.addAll(ref.getFormula().references());
        return set;
    }
}
package spreadsheet;

import java.util.Set;
import spreadsheet.value.MaybeValue;
import spreadsheet.value.NoValue;

public class Reference implements Expression {
    private final Cell ref_cell;
    public Set<Cell> refs;

    public Reference(Cell ref) {
        this.ref_cell = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return ref_cell.evaluate();
    }

    @Override
    public void set_references(Set<Cell> refs) {
        this.refs = refs;
        this.push_references();
    }

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }

    /**
     * Si la formula de la celda es NoValue,
     * no podemos añadirle las referencias.
     * 
     */
    @Override
    public void push_references() {
        Expression formula = this.ref_cell.getFormula();
        if (formula != NoValue.noValue()){
            formula.set_references(this.refs);
        }
    }
}
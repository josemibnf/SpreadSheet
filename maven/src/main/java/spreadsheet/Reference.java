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
        if (this.ref_cell.getFormula()==NoValue.noValue()){
            this.ref_cell.add_reference(this);
        }else{
            this.push_references();
        }
    }

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }

    /**
     * Si la formula de la celda es NoValue,
     * no podemos añadirle las referencias.
     * 
     * Si se ejecuta con NoValue como formula de
     * la celda, no tendrá efecto.
     */
    @Override
    public void push_references() {
        this.ref_cell.getFormula().set_references(this.refs);
    }
}
package Expression;

import SpreadSheet.Cell;
import SpreadSheet.Expression;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression{
    private final Cell ref_cell;

    public Reference(Cell ref) {
        this.ref_cell = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return ref_cell.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> referencedCell = new HashSet<>();
        referencedCell.add(ref_cell);
        return referencedCell;
    }

}
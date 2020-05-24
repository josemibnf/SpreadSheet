package Expression;

import SpreadSheet.Cell;
import SpreadSheet.Expression;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {
    private final Cell REFERENCED_CELL;

    public Reference(Cell ref) {
        this.REFERENCED_CELL = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return REFERENCED_CELL.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> referencedCell = new HashSet<>();
        referencedCell.add(REFERENCED_CELL);
        return referencedCell;
    }

}
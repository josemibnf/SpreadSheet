package Expression;

import SpreadSheet.Cell;
import SpreadSheet.Expression;
import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {

    public final Expression exp1;
    public final Expression exp2;

    public Operation(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public abstract int operate(int i1, int i2);

    /**
     * Nos retorna el valor al realizar la operacion sobre las dos expresiones.
     *
     */
    public MaybeValue evaluate() {
        MaybeValue val1 = exp1.evaluate();
        MaybeValue val2 = exp2.evaluate();

        if (!val1.hasValue() || !val2.hasValue()) return new NoValue();

        SomeValue value1 = (SomeValue) val1;
        SomeValue value2 = (SomeValue) val2;

        return new SomeValue(operate(value1.getValue(), value2.getValue()));
    }

    /**
     * Añade el conjunto de celdas que poseen la expresion, directa o indirectamente.
     *
     */
    public Set<Cell> references(){
        Set<Cell> referenced_cells = new HashSet<>();

        referenced_cells.addAll(exp1.references());
        referenced_cells.addAll(exp2.references());

        return referenced_cells;
    }


}
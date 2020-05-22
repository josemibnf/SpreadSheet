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
     * Nos retorna el valor de operar el valor de las dos expresiones.
     */
    @Override
    public MaybeValue evaluate() {
        MaybeValue val1 = exp1.evaluate();
        MaybeValue val2 = exp2.evaluate();
        if (!val1.hasValue() || !val2.hasValue()) {
            return NoValue.noValue();
        }
        SomeValue value1 = (SomeValue) val1;
        SomeValue value2 = (SomeValue) val2;
        return new SomeValue(operate(value1.getValue(), value2.getValue()));
    }

    public Set<Cell> references(){
        Set<Cell> allCellsInvolved = new HashSet<>();
        allCellsInvolved.addAll(exp1.references());
        allCellsInvolved.addAll(exp2.references());
        return allCellsInvolved;
    }


}
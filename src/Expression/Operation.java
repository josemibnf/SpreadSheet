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
    public Set<Cell> refs;

    public Operation(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.refs = new HashSet<>();
    }

    public abstract int operate(int i1, int i2);

    /**
     * Nos retorna el valor de operar el valor de las dos expresiones.
     */
    @Override
    public MaybeValue evaluate() {
        MaybeValue val1 = exp1.evaluate();
        MaybeValue val2 = exp2.evaluate();
        if (val1.hasValue() && val2.hasValue()) {
            SomeValue som1 = (SomeValue) val1;
            SomeValue som2 = (SomeValue) val2;
            return new SomeValue(operate(som1.getValue(), som2.getValue()));

        } else {
            return NoValue.noValue();
        }
    }

    @Override
    public void set_references(Set<Cell> refs) {
        this.refs.addAll(refs);
        this.push_references();
    }

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }

    @Override
    public void push_references() {
        this.exp1.set_references(this.refs);
        this.exp2.set_references(this.refs);
    }


}
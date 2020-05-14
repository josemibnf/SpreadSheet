package spreadsheet.opt;

import spreadsheet.Cell;
import spreadsheet.Expression;
import java.util.HashSet;
import java.util.Set;
import spreadsheet.value.MaybeValue;
import spreadsheet.value.NoValue;
import spreadsheet.value.SomeValue;

public abstract class Operation implements Expression {

    public final Expression exp1;
    public final Expression exp2;
    
    public Operation(Expression exp1, Expression exp2){
        // Constructor ¿? No se en el pdf lo pone.
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public abstract int operate(int i1, int i2);

    /**
     * Nos retorna el valor de operar el valor de las dos expresiones.
     */
    @Override
    public MaybeValue evaluate() {
        MaybeValue val1=exp1.evaluate();
        MaybeValue val2=exp2.evaluate();
        if (val1.hasValue() && val2.hasValue()){
            SomeValue som1=(SomeValue)val1;
            SomeValue som2=(SomeValue)val2;
            return new SomeValue(operate(som1.getValue(), som2.getValue()));
        }else{
            return NoValue.noValue();
        }
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> set = new HashSet<Cell>();
        set.addAll(exp1.references());
        set.addAll(exp2.references());
        return set;
    }

}
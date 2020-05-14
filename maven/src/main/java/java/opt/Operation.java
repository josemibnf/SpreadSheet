package java.opt;

import java.Expression;

public abstract class Operation implements Expression {

    public final Expression exp1;
    public final Expression exp2;
    
    public Operation(Expression exp1, Expression exp2){
        // Constructor ¿? No se en el pdf lo pone.
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public abstract int operate(int i1, int i2);
}
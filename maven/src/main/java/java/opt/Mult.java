package java.opt;

import java.Expression;

public class Mult extends Operation {

    public Mult(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        // TODO Auto-generated constructor stub
    }

    public int operate(int i1, int i2) {
        return i1 * i2;
    }
}
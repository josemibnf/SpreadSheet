package Expression;

import SpreadSheet.Expression;

public class Plus extends Operation {

    public Plus(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    public int operate(int i1, int i2) {
        return i1 + i2;
    }

}
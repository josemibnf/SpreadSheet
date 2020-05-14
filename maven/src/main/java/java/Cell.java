package java;

import java.expressions.Expression;
import java.value.MaybeValue;

public class Cell {

    private MaybeValue value;
    private Expression formula;

    public Cell(){
        
    }

    public MaybeValue evaluate(){
        return null;
        
    }

    public void set(Expression exp){
        this.formula=exp;
    }

    public Expression getFormula() {
        return this.formula;
    }
}
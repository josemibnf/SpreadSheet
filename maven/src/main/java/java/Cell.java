package java;

public class Cell {

    private MaybeValue value;
    private Expression formula;

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
package SpreadSheet;

import Value.MaybeValue;
import Value.NoValue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cell {

    private Expression expression;
    private MaybeValue value;
    private List<Cell> observers = new ArrayList<>();

    public Cell(){
        expression = new NoValue();
    }

    public Cell(Expression expr){
        expression = expr;
    }

    public MaybeValue getValue() {
        return value;
    }

    public void registerObservers(Cell cell){
        observers.add(cell);
    }

    public void unregisterObservers(Cell cell){
        observers.remove(cell);
    }

    private void notifyObservers(){
        for(Cell observer : observers){
            observer.recalculate();
        }
    }

    public void recalculate(){
        evaluate();
        notifyObservers();
    }

    public MaybeValue evaluate(){
        MaybeValue value = expression.evaluate();
        this.value = value;
        return value;
    }

    public Expression getExpression() {
        return expression;
    }

    public void insert(Expression exp){
        set(exp);
        recalculate();
    }

    public void set(Expression exp) {
        Set<Cell> oldReferences = expression.references();
        expression = exp;
        Set<Cell> newReferences = expression.references();
        observeNewReferences(oldReferences, newReferences);
    }


    private void observeNewReferences(Set<Cell> oldReferences, Set<Cell> newReferences){
        for(Cell old : oldReferences){
            old.unregisterObservers(this);
        }
        for(Cell toObserve : newReferences){
            toObserve.registerObservers(this);
        }
    }
}

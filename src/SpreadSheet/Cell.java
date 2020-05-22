package SpreadSheet;

import Value.MaybeValue;
import Value.NoValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cell {

    private Expression formula;
    private MaybeValue value;

    private List<Cell> observers = new ArrayList<>();

    public Cell(){
        formula = new NoValue();
        value = new NoValue();
    }

    /**
     * Asigna a value el valor que posee la formula, si no lo sabemos aun será
     * NoValue.
     *
     * En el PDF lo que hace es retornar el valor. ?¿?¿?
     *
     */
    public void reevaluate(){
        evaluate();
        notifyObserver();
    }

    /**
     * Setter value
     *
     */
    public MaybeValue evaluate(){
        MaybeValue value = formula.evaluate();
        this.value = value;
        return value;
    }

    /**
     * Getter value
     *
     */
    public MaybeValue getValue() {
        return value;
    }

    // Patro Observer

    public void addObserver(Cell cell){
        observers.add(cell);
    }

    public void deleteObserver(Cell cell){
        observers.remove(cell);
    }

    private void updateObservers(Set<Cell> referencesToUpdate, Set<Cell> newReferences){
        for(Cell oldReference : referencesToUpdate){
            oldReference.deleteObserver(this);
        }

        for(Cell newReference : newReferences){
            newReference.addObserver(this);
        }
    }

    private void notifyObserver(){
        for(Cell observer : observers){
            observer.reevaluate();
        }
    }

    public void insert(Expression exp){
        set(exp);
        reevaluate();
    }

    public void set(Expression exp) {
        Set<Cell> oldReferences = formula.references();
        formula = exp;
        Set<Cell> newReferences = formula.references();
        updateObservers(oldReferences, newReferences);
    }



}

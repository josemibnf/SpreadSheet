package SpreadSheet;

import Expression.MaybeValue;
import Expression.NoValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cell {

    private Expression formula;
    private MaybeValue value;

    private List<Cell> observers = new ArrayList<>();

    public Cell() {
        formula = new NoValue();
        value = new NoValue();
    }

    /**
     * Asigna a value el valor que posee la formula, si no lo sabemos aun será
     * NoValue.
     */
    public void reevaluate() {
        evaluate();
        notifyObserver();
    }

    /**
     * Setter value
     */
    public MaybeValue evaluate() {
        value = formula.evaluate();
        return value;
    }

    /**
     * Getter value
     */
    public MaybeValue getValue() {
        return value;
    }

    // Patron Observador

    public void addObserver(Cell cell) {
        observers.add(cell);
    }

    public void deleteObserver(Cell cell) {
        observers.remove(cell);
    }

    private void updateObservers(Set<Cell> oldReferences, Set<Cell> newReferences) {
        for (Cell newReference : newReferences) {
            newReference.addObserver(this);
        }

        for (Cell oldReference : oldReferences) {
            oldReference.deleteObserver(this);
        }
    }

    private void notifyObserver() {
        for (Cell observer : observers) {
            observer.reevaluate();
        }
    }

    /**
     * Actualiza una celda con la nueva expresion, lo que provoca una actualizacion de los observadores
     */
    public void insert(Expression expression) {
        Set<Cell> oldReferences = formula.references();
        formula = expression;
        Set<Cell> newReferences = formula.references();
        updateObservers(oldReferences, newReferences);
        reevaluate();
    }
}

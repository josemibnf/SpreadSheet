package spreadsheet.value;

import java.util.HashSet;
import java.util.Set;

import spreadsheet.Cell;

public class SomeValue extends MaybeValue {

    private final int value;
    private Set<Cell> refs;

    public SomeValue(int i) {
        this.value = i;
        this.refs = new HashSet<>();
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> get_references() {
        return this.refs;
    }    
    
    @Override
    public void push_references() {
        // No tiene a quien comunicar su existencia.
    }

    @Override
    public void set_references(Set<Cell> refs) {
        this.refs.addAll(refs);
        this.notify_references();
    }

    /**
     * Se ejecuta en el mismo momento que las otras
     * expresiones ejecutan push_references, 
     * pero en este caso, como hemos modificado un valor,
     * hacemos que todas las celdas de la cadena revaluen 
     * sus valores.
     * 
     * La primera celda deberia ser la mas cercana en referencia.
     * 
     */
    private void notify_references(){
        for (Cell c : this.refs){
            c.revaluate();
        }
    }
    
}
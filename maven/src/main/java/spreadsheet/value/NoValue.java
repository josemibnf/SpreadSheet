package spreadsheet.value;

import java.util.Set;

import spreadsheet.Cell;

public class NoValue extends MaybeValue {

    // Con esta clase seguimos el patron NullObject y Singleton.

    private static NoValue instance = new NoValue();

    private NoValue() {
    }

    /**
     * Retorna la instancia de NoValue.
     * 
     * @return
     */
    public static NoValue noValue() {
        return instance;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return instance;
    }


    /**
     * No podemos hacer set/get/push_references a una formula
     * que apunte a NoValue, ya que al estar aplicando 
     * el patron Singleton, es el mismo objeto y las
     * referencias se almacenarian de todas las celdas.
     */
    @Override
    public void set_references(Set<Cell> refs) {
    }

    @Override
    public Set<Cell> get_references() {
        
        return null;
    }

    @Override
    public void push_references() {

    }
    
}
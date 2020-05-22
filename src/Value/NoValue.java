package Value;

import SpreadSheet.Cell;

import java.util.HashSet;
import java.util.Set;

public class NoValue extends MaybeValue {

// Con esta clase seguimos el patron NullObject y Singleton.

    private static NoValue instance = new NoValue();

    public NoValue() {
        super(false);
    }

    /**
     * Retorna la instancia de NoValue.
     *
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

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }

}
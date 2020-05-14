package java.value;

public class NoValue extends MaybeValue { 

    // Con esta clase seguimos el patron NullObject y Singleton.
    
    private static NoValue instance = new NoValue();
    private NoValue(){
    }

    /**
     * Retorna la instancia de NoValue.
     * @return
     */
    public static NoValue noValue(){
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
    
}
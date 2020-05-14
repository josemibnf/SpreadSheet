package java.value;

public class NoValue extends MaybeValue { // Con esta clase seguimos el patron NullObject.
    
    private static NoValue instance = new NoValue();

    private NoValue(){
    }

    @Override
    public boolean hasValue() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * Se aplica el patron Singleton.
     */
    @Override
    public MaybeValue evaluate() {
        return instance;
    }
    
}
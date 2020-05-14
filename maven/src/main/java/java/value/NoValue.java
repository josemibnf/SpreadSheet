package java.value;

public class NoValue extends MaybeValue { // Con esta clase seguimos el patron NullObject.

    // HAY QUE APLICARLE EL SINGLETON.
    
    @Override
    public boolean hasValue() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
package java.value;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int i) {
        this.value = i;
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
    
}
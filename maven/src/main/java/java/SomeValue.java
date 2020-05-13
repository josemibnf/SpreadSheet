public class SomeValue extends MaybeValue{

    private int value;

    public SomeValue(int i){
        this.value=i;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public boolean hasValue() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
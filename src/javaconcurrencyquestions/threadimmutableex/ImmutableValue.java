package javaconcurrencyquestions.threadimmutableex;

public class ImmutableValue {

    private int value = 0;

    public ImmutableValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
//add method returns a new instance with the increased value making the original object immutable

    public ImmutableValue add(int valueToAdd){
        return new ImmutableValue(this.value + valueToAdd );
    }
}

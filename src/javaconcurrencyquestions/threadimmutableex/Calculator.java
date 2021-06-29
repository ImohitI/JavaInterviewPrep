package javaconcurrencyquestions.threadimmutableex;

public class Calculator {
    /*
    Reference is not thread safe even if object is thread safe
    Here we can change the reference through add and setValue methods
    So even if Calculator use an immutable object internally , it is not itself immutable.
    and therefore not thread safe.
    Therefore the ImmutableValue class is threadsafe but the use of it is not.

    To make the Calculator class thread safe we can make add and setValue method synchronized

     */
    ImmutableValue currentValue = null;

    public ImmutableValue getValue(){
        return currentValue;
    }

    public void setValue(ImmutableValue newValue){
        this.currentValue = newValue;
    }

    public void add(int newValue){
        this.currentValue = this.currentValue.add(newValue);
    }
}

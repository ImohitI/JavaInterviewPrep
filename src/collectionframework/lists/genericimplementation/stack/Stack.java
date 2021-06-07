package collectionframework.lists.genericimplementation.stack;

public class Stack<T>{
    private static int MAX_SIZE=40;
    private Element<T> top;
    private int size = 0;

    public void push(T data) throws StackOverflowException{
        if(size == MAX_SIZE){
            throw new StackOverflowException();
        }
        Element elem = new Element(data, top);
        top = elem;
        size++;
    }

    public T pop() throws StackUnderFlowException{
        if(size == 0){
            throw new StackUnderFlowException();
        }
        T data = top.getData();
        top  = top.getNext();
        size--;
        return data;
    }

    public T peek() throws StackUnderFlowException{
        if(size == 0){
            throw new StackUnderFlowException();
        }
        return top.getData();
    }
}

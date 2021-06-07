package collectionframework.lists.genericimplementation.linkedlist;

public class Node<T extends Comparable<T>> {
    /*
    the data should be comparable , this for equality checks so you can do things like find what index a particular element is located
    public int compareTo(T o);
     */
    private T data;
    private  Node<T> next;

    public Node(T data){
        this.data = data;
        setNext(null);
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }
    public String toString(){
        return String.valueOf(data);
    }
}

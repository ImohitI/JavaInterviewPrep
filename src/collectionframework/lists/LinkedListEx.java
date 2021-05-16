package collectionframework.lists;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {

        /*
        private static class Node => item , prev, next

        --first and last Node elements

        --unlink(Node<E> x)
        E element = x.item;
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        if(prev == null){
            first = next;
        }else{
            prev.next = next;
            x.prev = null;
        }

        if(next == null){
            last = prev;
        }else{
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        return element;
        ---------------------
        add calls linklast(E e)
        Node<E> l = last;
        Node<E> newNode = new Node(l , e , null);
        last = newNode;
        if(l == null){
            first = newNode;
        }else{
            l.next = newNode;
        }


         */
        // class linked list
        LinkedList<String> ll
                = new LinkedList<String>();

        // Adding elements to the linked list
        ll.add("A");
        ll.add("B");
        ll.addLast("C");
        ll.addFirst("D");
        ll.add(2, "E");

        System.out.println(ll);

        ll.remove("B");
        ll.remove(3);
        ll.removeFirst();
        ll.removeLast();

        ll.iterator();
        System.out.println(ll);


    }
}

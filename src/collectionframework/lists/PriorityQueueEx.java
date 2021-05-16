package collectionframework.lists;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {

        /*
        PriorityQueue does not permit null
        Cannot create priority queue with non comparable objects
        PriorityQueue are unbounded queues
        head or front of the queue contains the least element as per natural ordering.
        priorityQueue implementation is not thread safe.


        The queue retrieval operations poll , remove , peek and elements access the element at the head of the queue.
        It provides  O(log n) time to add and poll methods.

        add(E element)
        peek() -- retrieve head of the queue but does not remove
        poll() -- retrieve and remove head of this queue or returns null if this queue is empty


         */
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());


        //comparator example
        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };

        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(stringLengthComparator);

        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("Jhon");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        while(!namePriorityQueue.isEmpty()){
            System.out.println(namePriorityQueue.remove());
        }
        //the user defined object can be used , implements Comparable<Employee>

        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>();

        employeePriorityQueue.add(new Employee("Mukesh" , 10000));
        employeePriorityQueue.add(new Employee("Chris", 145000));
        employeePriorityQueue.add(new Employee("Jack", 1670000));

        while(!employeePriorityQueue.isEmpty()){
            System.out.println(employeePriorityQueue.remove());
        }
    }
}
class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name , double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int compareTo(Employee employee) {
        if(this.getSalary() > employee.getSalary()) {
            return 1;
        } else if (this.getSalary() < employee.getSalary()) {
            return -1;
        } else {
            return 0;
        }
    }
}

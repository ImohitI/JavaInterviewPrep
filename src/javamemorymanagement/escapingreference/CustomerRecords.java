package javamemorymanagement.escapingreference;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CustomerRecords {
    private Map<String, Customer> records;

    public CustomerRecords(){
        this.records = new HashMap<String, Customer>();
    }

    public void addCustomer(Customer c){

        this.records.put(c.getName(), c);
    }

    public Map<String , Customer> getCustomer(){
        //return this.records;// escape reference issue , the calling method gets access to the map reference , one can mutate the private variable records
        //return new HashMap<String , Customer>(this.records);// by creating a new hashmap using this constructor we will always share a reference to a new constructor so mutating it will not change out variable records
        /*
        Even creating a new HashMap may not be full proof as the calling method can still change the values of the underlying object
        The elegant solution is to return the immutable object
        Collections.unmodifiableMap
        Collections.unmodifiableList
         */
        return Collections.unmodifiableMap(this.records);
    }

    public Customer getCustomerByName(String name){
        //return this.records.get(name);
        return new Customer(this.records.get(name));
        /*
        A full proof way is to give an interface which does not give access to mutable methods and ony read only methods are given access to the caller method

         */
    }

    public CustomerReadOnly getCustomerByNameReadOnly(String name){
        return this.records.get(name);
    }

    public static void main(String[] args) {
        CustomerRecords records = new CustomerRecords();

        records.addCustomer(new Customer("Jhon"));
        records.addCustomer(new Customer("Simon"));

       // records.getCustomer().clear();// java.lang.UnsupportedOperationException // for Collections.unmodifiableMap()

        for(Customer next : records.getCustomer().values()){
            System.out.println(next);
        }

        System.out.println("---------------");
       // Customer Jhon = records.getCustomerByName("Jhon");
        CustomerReadOnly Jhon = records.getCustomerByName("Jhon");
        System.out.println(Jhon.getName());
        //Jhon.setName("Derek"); not valid
        System.out.println(Jhon.getName());

        for(Customer next : records.getCustomer().values()){
            System.out.println(next);
        }
    }
}
class Customer implements CustomerReadOnly {
    String name;

    @Override
    public String getName(){
        return this.name;
    }
    public Customer(String name){
        this.name = name;
    }

    public Customer(Customer oldCustomer){
        this.name = oldCustomer.name;
    }

    @Override
    public String toString(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}

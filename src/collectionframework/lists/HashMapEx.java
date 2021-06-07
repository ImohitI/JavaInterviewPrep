package collectionframework.lists;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        /*
        A map is a key value mapping , every map is valued to one value

        HashMap allows null as key
        Can insert the same object twice with different key

    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }

        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
        Objects.equals(description, product.description);
    }



 hash method
 return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);

        HashMap
        array of Nodes
        Node<K,V> [] table

   -----put operation
        table[i = (n - 1) & hash(key)] // finding the write index to put new Node in table
        if the place is already having a node , this leads to collision as now two nodes have the same has thats why they are
        going to be placed at the same index
        this is stored as a linked list with the head present at the index of the table
        to place our new node we need to find the end of the linked list and place it at the end

   -----get operation
        find the index with the hash , then search through the linked list , checking equality of key
        if (e.hash == hash &&
        ((k = e.key) == key || (key != null && key.equals(k))))
        return e;

         */

        int h = 6;
        h = 26 >>> 2; // 11010 >>> 2(n) ----> 110 // it divides the operand by 2^n , here n =2 , 26 / 4 = 6
        System.out.println(h);// 6

        // Create an empty hash map
        HashMap<String, Integer> map = new HashMap<>();

        // Add elements to the map
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Print size and content
        System.out.println("Size of map is:- "
                + map.size());
        System.out.println(map);

        // Check if a key is present and if
        // present, print value
        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
            System.out.println("value for key"
                    + " \"vishal\" is:- " + a);
        }

        // Iterate the map using
        // for-each loop
        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());


        //Objects;


        Map<Product, Integer> hmap = new HashMap<>();
        Product p1 = new Product("Product1" , "One Product");
        Product p2 = new Product("Product2" , "Two Product");
        hmap.put(p1, 1);
        hmap.put(p2, 2);

        for(Map.Entry<Product, Integer> m : hmap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue()+" ");
        }


    }
}
class Product{
    private String name;
    private String description;
    private List<String> tags;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Product product  = (Product)o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description , product.description);
    }

    public int hashCode(){
        return Objects.hash(name, description);
    }
}
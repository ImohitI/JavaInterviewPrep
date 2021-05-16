package javamemorymanagement;



public class GCMain {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        long availableBytes = runtime.freeMemory();
        System.out.println("Available memory: "+ availableBytes/1024 +"k");

        //let's create a ton of garbage
        for(int i=0; i < 100; i++){
            Customer c;
            c = new Customer("Jhon");
        }

        availableBytes = runtime.freeMemory();
        System.out.println("Available memory: "+availableBytes/1024 +"k");

        System.gc();

        availableBytes = runtime.freeMemory();
        System.out.println("Available memory: "+availableBytes/1024 +"k");

    }
}
class Customer{
    String name;
    public Customer(String name){
        this.name = name;
    }

    public void finalize(){
        System.out.println("This object is being gc'd");
    }
}

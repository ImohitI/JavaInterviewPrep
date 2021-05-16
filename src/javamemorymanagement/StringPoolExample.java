package javamemorymanagement;

public class StringPoolExample {
    public static void main(String[] args) {
        String one = "hello";
        String two = "hello";

        if(one == two){
            System.out.println("they are the same object");
        }else{
            System.out.println("they are different objects");
        }

        String three = new Integer(76).toString().intern();
        String four = "76";

        if(three == four){
            System.out.println("they are the same object");
        }else{
            System.out.println("they are different objects");
        }

    }
}


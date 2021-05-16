package javamemorymanagement;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    public static void start(){
        String last = "Z";
        Container container = new Container();
        container.setInitial("C");
        another(container , last);
        System.out.println(container.getInitial());
        System.out.println(last);
    }

    public static void another(Container initialHolder, String newInitial){
        newInitial.toLowerCase();
        initialHolder.setInitial("B");
        Container initial2 = new Container();
        initialHolder = initial2;
        System.out.println(initialHolder.getInitial());
        System.out.println(newInitial);
    }
}
class Container{
    String value = "A";
    public String getInitial(){
        return this.value;
    }

    public void setInitial(String val){
        this.value = val;
    }

}

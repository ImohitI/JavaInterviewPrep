package algorithms;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        try{
            bad();
            System.out.println("A");
        }catch (Exception e){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
        System.out.println("D");


   /*     long[] l = new  long[]{3,4,5};
        fix(l);
        System.out.println(Arrays.toString(l));
        System.out.println(1+ 5 +"");


        Parent p = new Parent();
        Parent p1 = new Child();
        Child c = new Child();

        print(p);
        print(p1);
        print(c);*/
      /*  PriorityQueue p;

        Set<mmm> set = new HashSet<>();

        mmm m1 = new mmm(1);
        mmm m2 = new mmm(2);
        set.add(m1);
        set.add(m1);
        set.add(m2);
        set.add(m2);
        System.out.println(set.size());
        m2.i = 1;
        System.out.println(set.size());
        set.remove(m1);
        System.out.println(set.size());
        set.remove(m2);
        System.out.println(set.size());*/
       // decrease(2);
/*
        HashSet<Object> hs = new HashSet<Object>();
        MyString m1 = new MyString("mk");
        MyString m2 = new MyString("mk");

        String m3 = new String("mk");
        String m4 = new String("mk");
        hs.add(m1);
        hs.add(m2);
        hs.add(m3);
        hs.add(m4);

        System.out.println(hs.size());*/

/*        String str = "AGCT";

        for(int i = 0 ; i < str.length() ; i++){

            String sub1 = str.substring(0,i);
            String sub2 = str.substring(i+1);
            System.out.println(sub1+"");

            String newString = sub1+sub2;
            System.out.println(newString);
        }*/
    }
    static void print(Parent p){
        p.m1();;
    }
    static void decrease(int num){
        if(num >=0){
            decrease(num -1);
        }
        System.out.println("Number: "+num);
    }
    static long[] fix(long[] a){
        a[1] = 7;
        return a;
    }
    static void bad(){
        throw new Error();
    }

}
class MyString{
    private String s;
    public MyString(String s){
        this.s = s;
    }
}

class mmm{
    public int i;
    public mmm(int i ){ this.i = i;}
    public boolean equals(Object o ){ return i == ((mmm)o).i;}
    public int hashCode(){return i;}
}
class Parent{
    void m1() {
        System.out.println("b");
    }
}
class Child extends Parent{
    void m1(){
        System.out.println("d");
    }
}

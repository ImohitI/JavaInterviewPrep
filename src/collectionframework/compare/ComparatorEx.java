package collectionframework.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(101, "Vijay", 23));
        list.add(new Student(103,"Ajay", 27));
        list.add(new Student(102, "Jai", 21));

        Collections.sort(list, new AgeComparator());
        for(Student s : list){
            System.out.println(s.age +" "+s.rollNo +" "+ s.name);
        }
    }
}
class Student{
    int rollNo;
    String name;
    int age;
    Student(int rollNo, String name, int age){
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
    }
}
class AgeComparator implements Comparator<Student> {
    public int compare(Student s1 , Student s2){
        if(s1.age == s2.age){
            return 0;
        }else if(s1.age > s2.age){
            return 1;
        }else{
            return -1;
        }
    }
}
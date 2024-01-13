package oldmainfiles;

import java.util.Arrays;

public class Main007 {
    public static void main(String[] args) {
        double a = 0.7;
        double b = 0.9;
        double x = a + 0.1;
        double y = b - 0.1;

        System.out.println("x = " + x);
        System.out.println("y = " + y );
        System.out.println(x == y);
        StringBuffer s;
        s = new StringBuffer("as");
        s.append("www");
        Person p = new Person();
        StringBuilder str = new StringBuilder("gfg");
        str.append("s");
        System.out.println(str.codePointAt(0));
        int[] arr1 = {1,2,3};

        int[] clonearr1 = arr1.clone();
        System.out.println(arr1 == clonearr1);

        int intArray[][] = {{1,2,3},{4,5}};

        System.out.println(arr1.toString() +" "+ arr1.hashCode());
        System.out.println(Arrays.toString(arr1));

        int cloneArray[][] = intArray.clone();

        // will print false
        System.out.println(intArray == cloneArray);

        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println(intArray[0] == cloneArray[0]);
        System.out.println(intArray[1] == cloneArray[1]);
        Arrays.asList(intArray);


/*        // Get the Array
        int intArr1[] = { 10, 20, 15, 22, 35 };

        // Get the second Array
        int intArr2[] = { 10, 15, 22 };

        // To compare both arrays
        System.out.println("Integer Arrays on comparison: "
                + Arrays.compare(intArr1, intArr2));*/

        int arr4[] = {1, 2, 3};
        int arr5[] = {1, 2, 3};
        if (Arrays.equals(arr4, arr5))
            System.out.println("Same");
        else
            System.out.println("Not same");

        // inarr1 and inarr2 have same values
        int inarr1[] = {1, 2, 3};
        int inarr2[] = {1, 2, 3};
        Object[] arr6 = {inarr1};  // arr1 contains only one element
        Object[] arr7 = {inarr2};  // arr2 also contains only one element
        if (Arrays.deepEquals(arr6, arr7))
            System.out.println("Same");
        else
            System.out.println("Not same");


        Parents obj = new Childs();
        obj.show();
    }
}
class Person {
    String name;
    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
}
class Boy extends Person{
    String school;
    public Boy(String school){
        this.school = school;
    }
}
class Parents {
    void show()
    {
        System.out.println("Parent's show()");
    }
}

// Inherited class
class Childs extends Parents {
    // This method overrides show() of Parent
    @Override
    void show()
    {
        super.show();
        System.out.println("Child's show()");
    }
}

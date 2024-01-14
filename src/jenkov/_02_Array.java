package jenkov;

import java.util.Arrays;
import java.util.Comparator;

public class _02_Array {
    public static void main(String[] args) {
        intro();
    }
    public static void intro(){
        /**
         * Array is collection of variable of the same type
         *
         */
        int[] intArray;
        //instantiating an array type
        intArray = new int[10];
        String[] stringArray = new String[10];
        /**
         * Java allows you to create an array of references to any type of object.
         *
         * Java Array Literals -- shortcut to creating array of primitive or strings
         */
        int[]  ints2 = { 1,2,3,4,5,6,7,8,9,10 };
        String[] strings = {"one", "two", "three"};
        System.out.println(strings.length);
        /**
         * Java array length cannot be changed
         * Iterating over array
         * for( int i=0 ; i < intArray.length; i++){
         *  sout(intArray[i]);
         * }
         * for( String x : stringArray){
         *  sout(x)
         * }
         */
        //multi dimensional array
        int[][] intAA = new int[10][20];
        //iterating multi dim array
        for(int i=0; i < intAA.length; i++){
            for(int j=0; j < intAA[i].length; j++){
                System.out.println("i: " + i + ", j: " + j);
            }
        }
        //inserting element into an array
        int[] ints = new int[20];
        int insertIndex = 10;
        int newValue = 123;
        //---------+----
        //move elements below insertion point
        for(int i = ints.length-1; i > insertIndex; i--){
            ints[i] = ints[i-1];
        }
        //insert new value
        ints[insertIndex] = newValue;
        System.out.println(Arrays.toString(ints));

        //remove element from an array
        int removeIndex = 10;
        for (int i = removeIndex; i < ints.length - 1; i++){
            ints[i] = ints[i + 1];
        }
        System.out.println(Arrays.toString(ints));
        //Finding Min and Max value
        int[] ints1 = {0,2,4,6,8,10};
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for ( int i= 0; i < ints1.length ; i++){
            if (ints1[i] < minVal) {
                minVal = ints1[i];
            }
            if (ints1[i] > maxVal) {
                maxVal = ints1[i];
            }
        }
        System.out.println(minVal);
        System.out.println(maxVal);

        /**
         * Array Class : Special utility class
         */
        //copy array
        int[] source = new int[10];
        int[] dest   = new int[10];

        for(int i=0; i < source.length; i++) {
            source[i] = i;
        }

        for(int i=0; i < source.length; i++) {
            dest[i] = source[i];
        }

        // best way :: coptyOf :: two parameters :: firs is source array :: second is legth of new array
        int[] dest1 = Arrays.copyOf(source, source.length);
        //copyOfRange
        int[] dest2 = Arrays.copyOfRange(source, 0, source.length);

        // toString()
        int[]   ints3 = new int[10];

        for(int i=0; i < ints3.length; i++){
            ints3[i] = 10 - i;
        }

        System.out.println(java.util.Arrays.toString(ints3));
        //sort
        Arrays.sort(ints3);
        System.out.println(Arrays.toString(ints3));

        //sorting array of objects
        /**
         * Comparator is an interface
         * Will discuss later
         */
        Employee[] employeeArray = new Employee[3];

        employeeArray[0] = new Employee("Xander", 1);
        employeeArray[1] = new Employee("John"  , 3);
        employeeArray[2] = new Employee("Anna"  , 2);

//        Arrays.sort(employeeArray, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });

        Arrays.sort(employeeArray, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.employeeId - e2.employeeId;
            }
        });
        for(int i=0; i < employeeArray.length; i++) {
            System.out.println(employeeArray[i].name);
        }


        //Array fill
        int[] intArray3 = new int[10];

        Arrays.fill(intArray3, 123);

        System.out.println(Arrays.toString(intArray3));

        intArray3 = new int[10];

        Arrays.fill(intArray3, 3, 5, 123) ;

        System.out.println(Arrays.toString(intArray3));

        //Binary search
        int[] ints4 = {0,2,4,6,8,10};

        int index = Arrays.binarySearch(ints4, 6);
        int index7 = Arrays.binarySearch(ints4, 7);
        int index12 = Arrays.binarySearch(ints4, 12);
        int indexPart = Arrays.binarySearch(ints4, 0, 4, 2);

        System.out.println(index);
        System.out.println(index7);
        System.out.println(index12);
        System.out.println(indexPart);

        //Arrays equals

        int[] ints11 = {0,2,4,6,8,10};
        int[] ints22 = {0,2,4,6,8,10};
        int[] ints33 = {10,8,6,4,2,0};

        boolean ints1EqualsInts2 = Arrays.equals(ints11, ints22);
        boolean ints1EqualsInts3 = Arrays.equals(ints11, ints33);

        System.out.println(ints1EqualsInts2);
        System.out.println(ints1EqualsInts3);

    }
    private static class Employee {
        public String name;
        public int    employeeId;

        public Employee(String name, int employeeId){
            this.name       = name;
            this.employeeId = employeeId;
        }
    }
}

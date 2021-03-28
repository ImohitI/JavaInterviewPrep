package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class SortAnArrayOf012 {
    public static void main(String[] args) {
        int arr[]= {0 ,1 ,2 ,0,1,0,2,2};
        //sort012_2(arr);

        MyObject[] myObjects = new MyObject[arr.length];
        for(int i = 0 ; i< arr.length ; i++){
            myObjects[i] = new MyObject(i,arr[i]);
        }

        System.out.println(Arrays.toString(myObjects));

        sort012_3(arr);
        System.out.println(Arrays.toString(arr));

        //sort in place check
        //[0, 0, 0, 1, 1, 1, 2, 2, 2]
        sort012_3(myObjects);
        System.out.println(Arrays.toString(myObjects));

    }
    //two pointer method
    /*

    Time Complexity: O(n).
    Only one traversal of the array is needed.
    Space Complexity: O(1).
    No extra space is required.

     */
    public static void sort012(int a[]) {

        int lo = 0;
        int mid = 0;
        int high = a.length-1;
        int temp = 0;
        while (mid <= high) {
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    a[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
/*
dividing problem into two parts
0 and 1
 1 and 2

 */
    public static void sort012_2(int a[]) {

        int lo = 0;
        int temp ;

        for(int i=0 ; i< a.length ; i++){
            if(a[i] ==2) continue;
            if(a[i] == 0){
                System.out.println("index i "+i);
                temp = a[lo];
                a[lo] = a[i];
                a[i] = temp;
                lo++;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(lo);
        for(int i=0 ; i< a.length ; i++){
            if(a[i] == 0) continue;
            if(a[i] == 1){
                System.out.println("index i ...."+i);
                temp = a[lo];
                a[lo] = a[i];
                a[i] = temp;
                lo++;
            }
        }
    }


    public static void sort012_3(int arr[]) {
        if(arr.length == 0 || arr.length == 1) return;

        int start = 0;
        int end = arr.length - 1;
        int index = 0;

        while(index <= end && start < end){

            if(arr[index] == 0){
                arr[index] = arr[start];
                arr[start] = 0;
                start++;
                index++;
            }else if( arr[index] == 2){
                arr[index] = arr[end];
                arr[end] = 2;
                end--;
            }else{
                index++;
            }

        }
    }

    //checking inplace behaviour

    public static void sort012_3(MyObject[] arr) {
        if(arr.length == 0 || arr.length == 1) return;

        int start = 0;
        int end = arr.length - 1;
        int index = 0;

        while(index <= end && start < end){

            if(arr[index].value == 0){
                MyObject temp = arr[index];
                arr[index] = arr[start];
                arr[start] = temp;
                start++;
                index++;
            }else if( arr[index].value == 2){
                MyObject temp = arr[index];
                arr[index] = arr[end];
                arr[end] = temp;
                end--;
            }else{
                index++;
            }

        }
    }
}
class MyObject{
    public int index;
    public int value;

    public MyObject(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "index=" + index +
                ", value=" + value +
                '}'+'\n';
    }
}
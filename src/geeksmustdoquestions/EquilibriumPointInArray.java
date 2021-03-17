package geeksmustdoquestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EquilibriumPointInArray {
    public static void main(String[] args) {
        int[] a1 = {20 ,17, 42, 25 ,32, 32, 30, 32, 37, 9 ,2, 33};
        System.out.println(IntStream.of(a1).sum());
        int[] a2 = {17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26, 21, 3};
        System.out.println(IntStream.of(a2).sum());
        long[] arr = {20 ,17, 42, 25 ,32, 32, 30, 32, 37, 9 ,2, 33, 31, 17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26, 21, 3};
       // long[] arr = {1,3,5,2,2};
        //int answer = equilibriumPoint2(arr, 30);
        int answer = equilibriumPoint3(arr, 30);
        System.out.println(answer);
    }
    //Time Complexity - O(n)  Auxiliary Space - O(1)
    public static int equilibriumPoint(long arr[], int n) {

        if(n==0 ){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int start = 0;
        int end = n-1;
        long leftSum = arr[start];
        long rightSum = arr[end];


        while(start < end){

            System.out.println("start "+start+" end "+end);

            System.out.println("leftSum "+leftSum+" rightSum "+rightSum);
            if(leftSum > rightSum){
                end--;
                rightSum += arr[end];
            }else if(rightSum > leftSum){
                start++;
                leftSum += arr[start];
            }else{
                start++;
                end--;
                leftSum += arr[start];
                rightSum += arr[end];

            }
        }
        System.out.println("......start "+start+" ........end "+end);
        if(leftSum == rightSum){
            if(start == end){
                return start + 1;
            }
        }
        return -1;
        // Your code here
    }
/*
just like a weighing pan
right side has the full weight
left side has nothing

now you lift first weight from right and check the balance
if not equal move the weight to left pan
then again lift the second weight from right and check the balance
if equal the index of the lifted weight is the answer
here add 1 to get the real index
 */
    public static int equilibriumPoint2(long arr[], int n) {
        long sum = 0;
        long leftSum = 0;

        for(long i : arr){
            sum += i;
        }

        for(int i = 0 ; i < arr.length ; i++){
            sum -= arr[i];
            if(leftSum == sum){
                return i+1;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    /*
    logic similar to firs approach
     */
    public static int equilibriumPoint3(long arr[], int n) {
        long left_sum = 0 ,right_sum = 0;
        int i = -1 , j = -1;
        for( i = 0, j = n-1 ; i < j ; i++, j-- ){
            left_sum += arr[i];
            right_sum += arr[j];

            // Keep moving i towards center until
            // left_sum is found lesser than right_sum
            while(left_sum < right_sum && i < j){
                i++;
                left_sum += arr[i];
            }
            // Keep moving j towards center until
            // right_sum is found lesser than left_sum
            while(right_sum < left_sum && i < j){
                j--;
                right_sum += arr[j];
            }
        }
        if(left_sum == right_sum && i == j)
            return i + 1;
        else
            return -1;

    }
}

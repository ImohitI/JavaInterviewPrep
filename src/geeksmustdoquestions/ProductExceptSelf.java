package geeksmustdoquestions;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
    //int A[] = {10, 3, 5, 6, 2};
    int A[] ={1,0};
        System.out.println(Arrays.toString(productExceptSelf(A)));

    }
    public static long[] productExceptSelf(int arr[])
    {
        // code here
        long[] a = new long[arr.length];
        long product = 1;
        int zeroCount = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0) {
                product = product * arr[i];
            }else{
                zeroCount++;
            }
        }
        System.out.println(product);
        for(int i = 0 ; i < a.length ; i++){
            if(zeroCount>1){
                a[i] = 0;
            }else if(zeroCount == 1){
                if(arr[i] == 0){
                    a[i] = product;
                }else{
                    a[i] = 0;
                }
            }
            else {
                    a[i] = product / arr[i];
                    System.out.println("i " + i + " arr[i] " + arr[i]);

            }
        }
        return a;
    }
}

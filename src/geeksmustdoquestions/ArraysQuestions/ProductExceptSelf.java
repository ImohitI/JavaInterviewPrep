package geeksmustdoquestions.ArraysQuestions;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
    int A[] = {10, 3, 5, 6, 2};
    //int A[] ={1,0};
        System.out.println(Arrays.toString(productExceptSelf(A, 5)));

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
       // System.out.println(product);
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
                  //  System.out.println("i " + i + " arr[i] " + arr[i]);

            }
        }
        return a;
    }
    public static long[] productExceptSelf(int arr[], int n){
        long[] prod = new long[n];

        if(n == 1){
            prod[0] = 1;
            return prod;
        }

        /*
        for(int i = 0 ; i < prod.length; i++){
            prod[i] = 1;
        }
        */
        //or
        Arrays.fill(prod, 1);

        //left prod
        long temp = 1;
        for(int i = 0 ; i < n ; i++){
            prod[i] = temp;// defaulted as 1 for first value
            temp = temp * arr[i];// prod of all elenment on the left of i+1 th index
        }

        temp = 1;

        for(int i = n-1 ; i >= 0 ; i--){
            prod[i] = prod[i] * temp; // defaulted as 1 for first value , prod holds the left product and temp holds the right product
            temp = temp * arr[i]; // temp holds the prod right value, to be used in i-1 th index
        }


        return prod;
    }
}

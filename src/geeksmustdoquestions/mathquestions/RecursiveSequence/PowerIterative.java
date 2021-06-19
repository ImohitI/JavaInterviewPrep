package geeksmustdoquestions.RecursiveSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
257599514
332322842
 */
public class PowerIterative {
    private static final int m = (int)Math.pow(10,9);
    static int power(int x , int y){
        int res = 1;
        while(y > 0){
            //if y is odd
            //multiply
            //x with result
            if((y & 1) == 1){
                res = res * x;
            }
            // n must be even now
            y = y >> 1;
            x = x * x;

        }
        return res;
    }

    public static void main(String[] args) {
   /*     int x = 3;
        int y = 5;
        System.out.println(power(3,5));

        int A[][] = {{4, 5, 6}, {1, 0, 0},
                {0, 1, 0}};
        int Z[][] = powerMatrix(A,3);
        int B[] = {3,2,1} ;
        int result = Z[0][0] * B[0] + Z[0][1] *B[1] + Z[0][2] * B[2];
*/
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        List<Integer> res = new ArrayList<Integer>();
        while(cases >0) {

            int k = scanner.nextInt();
            scanner.nextLine();
            int B[] = new int[k];
            int C[] = new int[k];
            int index = 0;
            while (index < k) {
                B[index] = scanner.nextInt();
                index++;
            }
            scanner.nextLine();

            index = 0;
            while (index < k) {
                C[index] = scanner.nextInt();
                index++;
            }
            scanner.nextLine();

            int n = scanner.nextInt();
            int result = 0;
            if (n <= k) {
                result = B[n-1]%m;
            } else{
                int CC[][] = new int[k][k];
                for (int i = 0; i < k; i++) {
                    CC[0][i] = C[i];
                }
                for (int i = 1, j = 0; i < k && j < k - 1; i++, j++) {
                    CC[i][j] = 1;
                }

                int Z[][] = powerMatrix(CC, n - k);

                for (int i = B.length - 1; i >= 0; i--) {
                    result = (result %m + (Z[0][B.length - i - 1] %m * B[i]%m ) %m )%m;
                }
            }
            //System.out.println(result);
            res.add(result%m);
            scanner.nextLine();
            cases--;
        }
        for(int i : res){
            System.out.println(i);
        }

    }



    // matrix multiplication
    static int[][] powerMatrix(int [][] x , int y){
       // int [][] f = x;
        int [][] res = new int[x.length][x.length];
        for(int i = 0 ; i < x.length ; i++){
            res[i][i] = 1;
        }
        while(y > 0){
            if((y & 1) == 1){
                //System.out.println("multiply by original x");
                multiply(res , x);
            }
            y = y >> 1;
            if(y >0) {
               // System.out.println("multiply to itself");
                multiply(x, x);
            }

        }
        return  res;
    }


    static void multiply(int a[][], int b[][])
    {
        // Creating an auxiliary matrix to
        // store elements of the
        // multiplication matrix
        int mul[][] = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                mul[i][j] = 0;
                for (int k = 0; k < a.length; k++)
                    mul[i][j] = (mul[i][j] %m+ (a[i][k]%m * b[k][j]%m)%m)%m;
            }
        }

        // storing the multiplication
        // result in a[][]
        for (int i=0; i<a.length; i++)
            for (int j=0; j<a.length; j++)

                // Updating our matrix
                a[i][j] = mul[i][j]%m;
    }

}

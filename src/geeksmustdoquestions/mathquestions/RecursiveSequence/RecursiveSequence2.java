package geeksmustdoquestions.RecursiveSequence;

import java.util.Scanner;

public class RecursiveSequence2 {
    static void multiply(int a[][], int b[][])
    {
        // Creating an auxiliary matrix to
        // store elements of the
        // multiplication matrix
        int mul[][] = new int[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                mul[i][j] = 0;
                for (int k = 0; k < 3; k++)
                    mul[i][j] += a[i][k]
                            * b[k][j];
            }
        }

        // storing the multiplication
        // result in a[][]
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)

                // Updating our matrix
                a[i][j] = mul[i][j];
    }

    // Function to compute F raise to
    // power n-2.
    static int power(int F[][], int n, int M[][])
    {/*
        int M[][] = {{4, 5, 6}, {1, 0, 0},
                {0, 1, 0}};
    */
        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1
        if (n == 1) {
           return 1;
        }
        power(F, n / 2, M);

        multiply(F, F);

        if (n%2 != 0)
            multiply(F, M);

        // Multiply it with initial values
        // i.e with F(0) = 0, F(1) = 1,
        // F(2) = 1

        return 1;
    }

    // Return n'th term of a series defined
    // using below recurrence relation.
    // f(n) is defined as
    // f(n) = f(n-1) + f(n-2) + f(n-3), n>=3
    // Base Cases :
    // f(0) = 0, f(1) = 1, f(2) = 1
    static int findNthTerm(int n , int k , int[][] B,int [][]F)
    {

        power(F, n-k, F);
        //multiply(F,B);
        
        return F[0][0] + F[0][1] +F[0][2];
    }

    // Driver code
    public static void main (String[] args) {

        int n = 6;
        int F[][] = {{4, 5, 6}, {1, 0, 0},
                {0, 1, 0}} ;
        int B[][] = {{3, 0, 0}, {2, 0, 0},
                {1, 0, 0}} ;
        System.out.println("F(6) is "
                + findNthTerm(n,3, B , F));


     /*   Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        System.out.println();

        while(cases >0){

            int k = scanner.nextInt();
            scanner.nextLine();
            int B[] = new int[k];
            int C[] = new int[k];
            int index = 0;
            while(index < k){
                B[index] = scanner.nextInt();
                index++;
            }
            scanner.nextLine();

            index = 0;
            while(index < k){
                C[index] = scanner.nextInt();
                index++;
            }
            scanner.nextLine();

           int n = scanner.nextInt();

            int CC[][] = new int[k][k];
            for(int i=0 ; i < k ; i++){
                CC[0][i] = C[i];
            }
            int BB[][] = new int[k][k];
            for(int i=k-1 ; i >=0 ; i--){
                BB[k-1-i][0] = B[i];
            }
            System.out.println(findNthTerm(n,k ,BB , CC ));

            scanner.nextLine();
            cases--;
        }*/

    }
}

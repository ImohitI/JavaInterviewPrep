package geeksmustdoquestions.RecursiveSequence;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveSequenceSPOJ {
    /*
3
3
5 8 2
32 54 6
2
3
1 2 3
4 5 6
6
3
24 354 6
56 57 465
98765432
     */
    public static void main(String[] args) {
      //  findNthTerm();

        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
       // System.out.println();

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

            int Z[] = new int[n];
            for(int i = 0 ; i < n ; i++){
                if(i < B.length){
                    Z[i] = B[i];
                }
            }
            System.out.println(findNthTerm(B , C , Z));

            scanner.nextLine();
            cases--;
        }

    }
    static int findNthTerm( int B[] , int C[], int Z[]){
/*        int k = 3;
        int n = 6;
        int B[] = {1, 2, 3};
        int C[] = {4, 5 , 6};
        int Z[] = {1 , 2 ,3 , 0 , 0 , 0 };

 */



        int k = B.length;
        int n = Z.length;
        int count = k+1;

        while(count <= n){
            int M[] = new int[3];
            int res = 0;
            for(int i = 0 ; i < k ; i++){
                M[i] = Z[count-i-2];
                res += M[i] * C[i];
            }


            Z[count-1] = res;
            count++;
        }

        //System.out.println(Arrays.toString(Z));

        return Z[Z.length-1] % (int)(Math.pow(10,9));
    }

}

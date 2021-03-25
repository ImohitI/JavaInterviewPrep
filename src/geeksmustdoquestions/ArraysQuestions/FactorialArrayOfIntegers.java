package geeksmustdoquestions.ArraysQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class FactorialArrayOfIntegers {
    public static void main(String[] args) {

       long A[] = {5, 6, 3};
       factorial(A);
    }
    public static long[] factorial(long a[]) {
        long max = -1;
        int MOD = 1000000007 ;

        List<Long> fact = new ArrayList<>();
        fact.add((long)1);

        for(long x : a ){
            max = Math.max(max, x);
        }
        for (int i = 1; i <= max; i++)
        {

            // Calculation of factorial
            // As fact[i-1] stores the factorial of n-1
            // so factorial of n is fact[i] = (fact[i-1]*i)
            fact.add((fact.get(i - 1) * i) % MOD);
        }

        long[] result   = new long[a.length];
        for(int i = 0 ; i < a.length ; i++){
            result[i] = fact.get((int) a[i]);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

package geeksmustdoquestions.mathquestions;

import java.math.BigInteger;

public class PalindromeNumbers {
    public static void main(String[] args) {

        int n = 123464321;
        int reverseN = reverseNumber(n);
        System.out.println("Reverse of n = " + reverseN);

        // Checking if n is same
        // as reverse of n
        if (n == reverseN)
            System.out.println("Palindrome = Yes");
        else
            System.out.println("Palindrome = No");

        if(checkPalindrome("233333333333333333333333332")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    static int reverseNumber(int n){
        int reverseN = 0;
        while(n > 0){
            reverseN = reverseN * 10 + n % 10;
            n = n/10;
        }
        return  reverseN;
    }

    static boolean checkPalindrome(String num){
        BigInteger n = new BigInteger(num);
        StringBuilder sb = new StringBuilder(n.toString());
        BigInteger r = new BigInteger(sb.reverse().toString());

        if(n.compareTo(r)== 0){
            return  true;
        }
        return false;
    }

}

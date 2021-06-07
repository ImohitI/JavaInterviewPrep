package geeksmustdoquestions.mathquestions;

public class CountDigits {
    public static void main(String[] args) {
        long n = 90993;
        System.out.println(countDigits(n));
        countDigits2(n);
    }
    static int countDigits(long n){
        int count = 0;
        while(n!=0){
            n = n/10;
            ++count;
        }
        return count;
    }
    //using string
    static void countDigits2(long n){
        String num = Long.toString(n);
        System.out.println(num.length());
    }
}

package LeetCode100;

public class _013RomanToInt {

    public static int romanToInt(String s) {
        int last = 0, total = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            int val = 0;
            switch (s.charAt(i)) {
                case 'I':
                    val = 1;
                    break;
                case 'V':
                    val = 5;
                    break;
                case 'X':
                    val = 10;
                    break;
                case 'L':
                    val = 50;
                    break;
                case 'C':
                    val = 100;
                    break;
                case 'D':
                    val = 500;
                    break;
                case 'M':
                    val = 1000;
                    break;

            }

            if (last > val) {
                total -= val;
            } else {
                total += val;
            }

            last = val;
        }
        System.out.println(">> " + total);
        return total;

    }

    public static void main(String[] args) {
        romanToInt("MCMXCIV");
    }
}
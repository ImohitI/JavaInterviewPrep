package LeetCode100;

public class _066PlusOne {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i > 0 && digits[i] > 9) {
                digits[i - 1] = digits[i - 1] + 1;
                digits[i] = 0;
            }
        }
        if (digits[0] > 9) {
            digits[0] = 0;
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }

    public int[] plusOne1(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
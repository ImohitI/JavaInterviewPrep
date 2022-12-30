package LeetCode100;

import java.util.Arrays;

public class _014LongestComPrefix {
    public static String longestComPrefix(String[] str) {

        String shortStr = Arrays.asList(str).stream().filter(x -> x != null)
                .reduce((x, y) -> x.length() < y.length() ? x : y)
                .get();

        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < shortStr.length(); i++) {

            char last = str[0].charAt(i);
            boolean stop = false;
            for (int j = 1; j < str.length; j++) {
                if (last != str[j].charAt(i)) {
                    stop = true;
                    break;
                }
            }
            if (stop)
                return s.toString();
            else
                s.append(last);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        String lcp = longestComPrefix(strs);
        System.out.println(lcp);
    }
}
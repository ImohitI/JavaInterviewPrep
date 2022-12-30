package LeetCode100;

import java.util.Stack;

public class _020ValidPara {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));

            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(i) == ')') {
                        if (stack.peek().equals('(')) {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                    } else if (s.charAt(i) == '}') {
                        if (stack.peek().equals('{')) {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                    } else if (s.charAt(i) == ']') {
                        if (stack.peek().equals('[')) {
                            stack.pop();
                        } else {
                            stack.push(s.charAt(i));
                        }
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }

        }
        return stack.size() == 0 ? true : false;
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '(') {
                stack.push(')');
            } else if (x == '{') {
                stack.push('}');
            } else if (x == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != x) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(])";
        // String s = "([])";
        System.out.println(isValid2(s));
    }
}

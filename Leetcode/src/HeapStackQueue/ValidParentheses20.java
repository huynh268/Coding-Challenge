package HeapStackQueue;

import java.util.Stack;

/**
 * Created by Tien on 11/2/2017.
 */
public class ValidParentheses20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("String \"[\" isValid? " + isValid("["));
        System.out.println("String \"()[]{}\" isValid? " + isValid("()[]{}"));
        System.out.println("String \"(([({()})]))((())){[{}]}\" isValid? " + isValid("(([({()})]))((())){[{}]}"));
    }
}

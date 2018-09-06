import java.util.Stack;

/**
 * Created by Tien on 9/5/2018.
 *
 *
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:
 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"

 Example 2:
 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses32 {

    /**
     * Stack
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        return max;
    }
}

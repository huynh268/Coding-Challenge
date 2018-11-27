package BackTracking;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 */

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(n, "", 0, 0, ans);
        return ans;
    }

    private void backtrack(int n, String current, int open, int close, List<String> ans) {
        if(current.length() == 2*n) {
            ans.add(current);
            return;
        }
        if(open < n) backtrack(n, current + "(", open + 1, close, ans);
        if(close < open) backtrack(n, current + ")", open, close + 1, ans);
    }
}

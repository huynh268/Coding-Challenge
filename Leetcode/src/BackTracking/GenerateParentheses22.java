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

    /**
     * Backtracking
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
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

    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0) {
            ans.add("");
        } else {
            for(int i = 0; i < n; i++) {
                for(String left : generateParenthesis2(i)){
                    for(String right : generateParenthesis2(n-i-1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return ans;
    }
}

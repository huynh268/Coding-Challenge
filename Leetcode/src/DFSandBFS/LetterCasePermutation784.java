package DFSandBFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 2/18/2018.
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length at most 12.
 S will consist only of letters or digits.
 */
public class LetterCasePermutation784 {

    /**
     * DFS - Recursive
     * O(n*2^n) Time complexity - Each letter has 2 ways to write upper ans lower cases
     *                          - There are 2^n ways if the string has n letters
     *                          - The iterate goes through n letter, therefore n*2^n
     * O(n*2^n) Space
     * @param S
     * @return
     */
    List<String> letterCasePermutation1(String S) {
        List<String> ans = new ArrayList<>();
        if(S.isEmpty()) {
            ans.add(S);
            return ans;
        }
        char[] c = S.toCharArray();
        dfs(c, 0, ans);
        return ans;
    }

    void dfs(char[] c, int i, List<String> ans) {
        if(i >= c.length) {
            ans.add(new String(c));
            return;
        }
        dfs(c, i+1, ans);
        if(c[i] >= 'a' && c[i] <= 'z') {
            c[i] = Character.toUpperCase(c[i]);
            dfs(c, i+1, ans);
        } else if (c[i] >= 'A' && c[i] <= 'Z') {
            c[i] = Character.toLowerCase(c[i]);
            dfs(c, i+1, ans);
        }
    }

    /**
     * BFS - Iterative
     * O(n*2^n) Time complexity
     * O(n*2^n) Space
     * @param S
     * @return
     */
    List<String> letterCasePermutation2(String S) {

    }
}

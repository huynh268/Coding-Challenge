package DynamicProgramming;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * Given a string, your task is to count how many palindromic substrings in this string.

 The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".
 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 Note:
 The input string length won't exceed 1000.
 */
public class PalindromicSubstrings647 {

    /**
     * DP
     * O(n^2) Time complexity
     * O(n^2) Space
     * @param s
     * @return
     */
    int countSubstrings1(String s) {
        if(s == null || s.length() < 1) return 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Expand palindrome around center
     * O(n^2) Time complexity
     * O(1) Space
     * @param s
     * @return
     */
    int count = 0;
    int countSubstrings2(String s) {
        if(s == null || s.length() < 1) return 0;
        for(int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return count;
    }

    void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
    }
}

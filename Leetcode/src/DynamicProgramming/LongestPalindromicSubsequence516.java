package DynamicProgramming;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

 Example 1:
 Input:

 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".
 Example 2:
 Input:

 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence516 {

    /**
     * O(n^2) Time complexity
     * O(n^2) Space
     * @param s
     * @return
     */
    int longestPalindromeSubseq(String s) {
        if(s == null || s.length() < 1) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}

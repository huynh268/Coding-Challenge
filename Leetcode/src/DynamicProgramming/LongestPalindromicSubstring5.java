package DynamicProgramming;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.


 Example:

 Input: "cbbd"

 Output: "bb"
 */
public class LongestPalindromicSubstring5 {

    /**
     * DP
     * O(n^2) Time complexity
     * O(n^2) Space
     * @param s
     * @return
     */
    String longestPalindrome1(String s) {
        int n = s.length();
        if(n <= 1) return s;

        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int start = 0;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(max < j - i + 1) {
                        max = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }

    /**
     * Expand the palindrome from the center
     * O(n^2) Time complexity
     * O(1) Space
     * @param s
     * @return
     */
    int max = 0;
    int start = 0;
    String longestPalindrome2(String s) {
        if(s.length() < 2) return s;
        for(int i = 0; i < s.length(); i++) {
            expand(s, i, i); //len is odd
            expand(s, i, i+1); //len is even
        }
        return s.substring(start, max);
    }

    void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if(max < j - i - 1) {
            max = j - i - 1;
            start = i + 1;
        }
    }

    /**
     *
     * @param s
     * @return
     */
    String longestPalindrome3(String s) {

    }
}

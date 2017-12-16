package Strings;

/**
 * Created by Tien on 12/3/2017.
 * Given two strings, s and t, find the length of their longest common substring.

 Example

 For s = "abcdxyz" and t = "xyzabcd", the output should be

 longestCommonSubstring(s, t) = 4;

 For s = "zxabcdezy" and t = "yzabcdezx", the output should be

 longestCommonSubstring(s, t) = 6.

 The longest common substring is "abcdez" and has a length of 6.
 */
public class LongestCommonSubstring {

    //Using DP
    int longestCommonSubstring(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int max = 0;

        int dp[][] = new int[sL+1][tL+1];

        for(int i = 0; i < sL; i++) {
            for(int j = 0; j < tL; j++) {
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                } else if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = max < dp[i][j] ? dp[i][j] : max;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }


}

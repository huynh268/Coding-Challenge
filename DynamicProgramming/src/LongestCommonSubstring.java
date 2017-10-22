/**
 * Created by Tien on 10/21/2017.
 */
public class LongestCommonSubstring {
    public static int LCSubstring(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int l1 = c1.length;
        int l2 = c2.length;

        if(l1 == 0 || l2 == 0) {
            return 0;
        }

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 0; i < l1+1; i++) {
            for(int j = 0; j < l2+1; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(c1[i-1] == c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < l1+1; i++) {
            for(int j = 0; j < l2+1; j++) {
                if(dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("abcdef, mbcdf: " + LCSubstring("abcdef", "mbcdf"));
    }

}

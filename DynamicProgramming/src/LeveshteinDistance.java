/**
 * Created by Tien on 10/17/2017.
 */
public class LeveshteinDistance {

    //Find the distance between 2 strings
    //Using recursive
    public static int editDistanceRecursive(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m == 0) return n;
        if(n == 0) return m;

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return editDistanceRecursive(s1.substring(0,m-2), s2.substring(0, n-2));
        }

        return 1 + min( editDistanceRecursive(s1.substring(0,m-2), s2.substring(0, n-1)),
                        editDistanceRecursive(s1.substring(0,m-1), s2.substring(0, n-2)),
                        editDistanceRecursive(s1.substring(0,m-2), s2.substring(0, n-2)));
    }

    //Using DP
    public static int editDistanceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m == 0) return n;
        if(n == 0) return m;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < m+1; i++) {
            int cost;
            for(int j = 1; j < n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    cost = 0;
                }
                else {
                    cost = 1;
                }

                dp[i][j] = min( dp[i-1][j] + 1,
                                dp[i][j-1] + 1,
                                dp[i-1][j-1] + cost);
            }
        }
        return dp[m][n];
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a,b),c);
    }
    public static void main(String[] args) {

        System.out.println(editDistanceDP("sunday","saturday"));
        System.out.println(editDistanceDP("cat","cut"));
        System.out.println(editDistanceDP("caat","cut"));

        System.out.println(editDistanceRecursive("sunday","saturday"));
    }
}

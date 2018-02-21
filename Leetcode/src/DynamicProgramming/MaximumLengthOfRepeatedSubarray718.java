package DynamicProgramming;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
 *
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

 Example 1:
 Input:
 A: [1,2,3,2,1]
 B: [3,2,1,4,7]
 Output: 3
 Explanation:
 The repeated subarray with maximum length is [3, 2, 1].
 Note:
 1 <= len(A), len(B) <= 1000
 0 <= A[i], B[i] < 100
 */
public class MaximumLengthOfRepeatedSubarray718 {

    /**
     * DP - Similar to Longest common substring
     * O(n^2) Time complexity
     * O(n^2) Space complexity
     * @param A
     * @param B
     * @return
     */
    int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if(n == 0 || m == 0) return 0;

        int[][] dp = new int[n+1][m+1];
        int max = 0;

        //Print out the longest repeated sub-array
        //Index of longest repeated sub-array
        int row = 0, col = 0;
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(max < dp[i][j]) {
                        max = dp[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
        }
        return max;
    }
}

package DynamicProgramming;

/**
 * Created by Tien on 1/18/2018.
 *
 *https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination,
 it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence300 {

    /**
     * DP
     * O(n^2) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return 1;

        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }


}


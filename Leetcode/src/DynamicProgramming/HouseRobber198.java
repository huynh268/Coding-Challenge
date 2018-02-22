package DynamicProgramming;

/**
 * Created by Tien on 2/22/2018.
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber198 {

    /**
     * DP
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    int rob1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length];
    }

    /**
     * DP
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int rob2(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int a = 0, b = nums[0];
        for(int i = 1; i < nums.length; i++) {
            b = Math.max(a + nums[i], a = b);
        }
        return Math.max(a,b);
    }
}

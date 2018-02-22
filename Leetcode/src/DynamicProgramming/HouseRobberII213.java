package DynamicProgramming;

/**
 * Created by Tien on 2/22/2018.
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 *
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 * This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security
 * system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII213 {

    /**
     * DP
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int rob1(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        //Start from nums[0] and exclude nums[len-1]
        int r0 = 0, r1 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            r1 = Math.max(r0 + nums[i], r0 = r1);
        }

        //Start from nums[1] ans exclude nums[0]
        int r2 = 0, r3 = 0;
        for(int i = 1; i < nums.length; i++) {
            r3 = Math.max(r2 + nums[i], r2 = r3);
        }
        return Math.max(r1, r3);
    }

    /**
     * DP
     * Modifying houseRobber with start index and end index
     * @param nums
     * @return
     */
    int rob2(int[] nums) {
        if(nums.length == 1) return nums[0];
        int max1 = rob(nums, 0, nums.length-2);
        int max2 = rob(nums, 1, nums.length-1);
        return Math.max(max1, max2);
    }

    int rob(int[] nums, int s, int e) {
        int a = 0, b = 0;
        for(int i = s; i <= e; i++) {
            b = Math.max(a + i, a = b);
        }
        return b;
    }
}

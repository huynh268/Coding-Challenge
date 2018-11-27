package Array;

/**
 * Created by Tien on 9/10/2018.
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 Each element in the array represents your maximum jump length at that position.
 Your goal is to reach the last index in the minimum number of jumps.

 Example:
 Input: [2,3,1,1,4]
 Output: 2
 Explanation: The minimum number of jumps to reach the last index is 2.
 Jump 1 step from index 0 to 1, then 3 steps to the last index.

 Note:
 You can assume that you can always reach the last index.
 */
public class JumpGameII45 {

    /**
     * Dynamic Programming
     *
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        if(nums.length == 1) return 0;

        int[] dp = new int[nums.length];

        for(int i = nums.length-1; i >= 0; i--) {
            if(i + nums[i] >= nums.length-1) {
                dp[i] = 1;
            } else {
                int min = nums.length;
                for(int j = i+1; j <= i + nums[i]; j++) {
                    min = Math.min(min, dp[j]);
                }
                dp[i] = 1 + min;
            }
        }

        return dp[0];
    }

    /**
     * Greedy
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        if(nums.length == 1) return  0;

        int step = 0;
        int lastIndex = 0;
        int maxJump = 0;

        for(int i = 0; i < nums.length-1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if(i == lastIndex) {
                step++;
                lastIndex = maxJump;
            }
        }

        return step;
    }
}

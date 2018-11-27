package Array;

/**
 * Created by Tien on 5/16/2018.
 *
 * https://leetcode.com/problems/jump-game/description/
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 Example 1:
 Input: [2,3,1,1,4]
 Output: true
 Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

 Example 2:
 Input: [3,2,1,0,4]
 Output: false
 Explanation: You will always arrive at index 3 no matter what. Its maximum
 jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame55 {

    /**
     * Dynamic Programming
     *
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];

        for(int i = nums.length-1; i >= 0; i--) {
            if(i + nums[i] >= nums.length-1) {
                dp[i] = true;
            } else {
                for(int j = i+1; j <= i+nums[i]; j++) {
                    if(dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
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
    public boolean canJump2(int[] nums) {
        int lastIndex = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(i + nums[i] >= lastIndex) lastIndex = i;
        }
        return lastIndex == 0;
    }
}

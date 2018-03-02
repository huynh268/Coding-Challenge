package DFSandBFS;

/**
 * Created by Tien on 3/1/2018.
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -.
 * For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.

 Example 1:
 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.

 Note:
 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum494 {

    /**
     * DFS
     * O(2^n) Time complexity - There are n nums, then there are n places to place + or -. Therefore 2^n ways to place + or -.
     * O(n) Space
     * @param nums
     * @param S
     * @return
     */
    int count = 0;
    int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        dfs(nums, 0, S, 0);
        return count;
    }

    void dfs(int[] nums, int sum, int target, int start) {
        if(start == nums.length) {
            if(sum == target) count++;
            return;
        } else {
            dfs(nums, sum - nums[start], target, start + 1);
            dfs(nums, sum + nums[start], target, start + 1);
        }
    }
}

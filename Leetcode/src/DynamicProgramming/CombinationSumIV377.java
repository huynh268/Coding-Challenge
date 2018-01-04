package DynamicProgramming;

/**
 * Created by Tien on 1/3/2018.
 *
 * Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

 Example:

 nums = [1, 2, 3]
 target = 4

 The possible combination ways are:
 (1, 1, 1, 1)
 (1, 1, 2)
 (1, 2, 1)
 (1, 3)
 (2, 1, 1)
 (2, 2)
 (3, 1)

 Note that different sequences are counted as different combinations.

 Therefore the output is 7.
 */
public class CombinationSumIV377 {

    /**
     * Recursive solution - does not work on large sum
      * @param nums
     * @param sum
     * @return
     */
    int combinationSum1(int[] nums, int sum) {
        if(sum == 0)
            return 1;

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum - nums[i] >= 0)
                count += combinationSum1(nums, sum - nums[i]);
        }

        return count;
    }

    /**
     * Top-down, using memoization
     * Based on Recursive solution
     * @param nums
     * @param sum
     * @return
     */
    int combinationSum2(int[] nums, int sum) {
        int[] memo = new int[sum+1];
        for (int i = 1; i < memo.length; memo[i++] = -1);
        memo[0] = 1;
        return helper(nums, sum, memo);
    }

    int helper(int[] nums, int sum, int[] memo) {
        if(memo[sum] != -1)
            return memo[sum];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum - nums[i] >= 0)
                count += helper(nums, sum - nums[i], memo);
        }
        memo[sum] = count;
        return memo[sum];
    }

    /**
     * Bottom-up, Dynamic Programming
     * @param nums
     * @param sum
     * @return
     */
    int combinationSum3(int[] nums, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;

        for(int i = 1; i <= sum; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0)
                    dp[i] += dp[i-nums[j]];
            }
        }

        return dp[sum];
    }
}

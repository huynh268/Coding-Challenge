package Array;

/**
 * Created by Tien on 1/1/2018.
 */
public class MaxSubArray53 {

    /**
     * Using DP - O(n) Time complexity - O(n) Space
     * @param nums
     * @return
     */
    int maxSubArray1(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i]+nums[i], nums[i]);
            max = dp[i] > max? dp[i]:max;
        }
        return max;
    }

    /**
     * Using DP - O(n) Time complexity - O(1) Space
     * @param nums
     * @return
     */
    int maxSubArray2(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        int a = nums[0], max = nums[0];

        for(int i = 1; i < n; i++) {
            a = Math.max(a+nums[i], nums[i]);
            max = a > max? a:max;
        }
        return max;
    }

    /**
     * Kadane's algorithm - O(n) Time Complexity - O(1) Space
     * @param nums
     * @return
     */
    int maxSubArray3(int[] nums) {
        int max = nums[0], maxHere = nums[0];

        for(int i = 1; i < nums.length; i++) {
            maxHere = Math.max(maxHere + nums[i], nums[i]);
            max = Math.max(max,maxHere);
        }
        return max;
    }
}

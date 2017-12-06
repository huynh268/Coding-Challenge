package DynamicProgramming;

/**
 * Created by Tien on 12/4/2017.
 * You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent houses on the street have a connected security system. The system will automatically trigger an alarm if two adjacent houses are broken into on the same night.

 Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the maximum amount of money you can rob in one night without triggering an alarm.

 Example

 For nums = [1, 1, 1], the output should be
 houseRobber(nums) = 2.

 The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.
 */
public class HouseRobber {

    int houseRobber1(int[] nums) {
        int n = nums.length;

        if(n == 0) return n;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        for(int i = 3 ; i <= n; i++)
            dp[i] = Math.max(dp[i-1], nums[i-1]+dp[i-2]);

        return dp[n];
    }

    int house2(int[] nums) {
        int n = nums.length;

        if(n == 0) return n;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int a = nums[0], b = Math.max(nums[0], nums[1]), c = 0;
        for(int i = 2; i < n; i++) {
            c = Math.max(a+nums[i], b);
            a = b;
            b = c;
        }
        return c;
    }

    int house3(int[] nums) {
        int a = 0, b = 0;

        for(int i : nums)
            b = Math.max(i + a, a = b);

        return b;
    }
}

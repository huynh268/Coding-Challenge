package DynamicProgramming;

/**
 * Created by Tien on 1/8/2018.
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

 Note:
 1- cost will have a length in the range [2, 1000].
 2- Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs746 {

    /**
     * DP - O(n) Time complexity and O(n) Space
     * @param cost
     * @return
     */
    int minCostClimbingStairs1(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i <= cost.length; i++) {
            if(i == cost.length)
                dp[i] = Math.min(dp[i-1], dp[i-1]);
            else
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return dp[cost.length];
    }

    /**
     * DP - O(n) Time complexity and O(1) Space
     * @param cost
     * @return
     */
    int minCostClimbingStairs2(int[] cost) {
        int a = cost[0], b = cost[1], ans = Math.min(a,b);

        for(int i = 2; i <= cost.length; i++) {
            if(i == cost.length)
                ans = Math.min(a,b);
            else
                ans = cost[i] + Math.min(a,b);

            a = b;
            b = ans;
        }

        return ans;
    }

    /**
     * DP Backward - O(n) Time complexity and O(n) Space
     * @param cost
     * @return
     */
    int minCostClimbingStairs3(int[] cost) {
        int[] dp = new int[cost.length+2];

        dp[cost.length] = 0;
        dp[cost.length+1] = 0;

        for(int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    /**
     * DP Backward - O(n) Time complexity and O(1) Space
     * @param cost
     * @return
     */
    int minCostClimbingStairs4(int[] cost) {
        int a = 0, b = 0, c = 0;

        for (int i = cost.length-1; i >= 0 ; i--) {
            c = cost[i] + Math.min(a, b);
            a = b;
            b = c;
        }

        return Math.min(a, b);
    }
}

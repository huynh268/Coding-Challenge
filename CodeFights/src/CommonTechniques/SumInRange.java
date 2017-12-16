package CommonTechniques;

/**
 * Created by Tien on 12/16/2017.
 *
 * You have an array of integers nums and an array queries, where queries[i] is a pair of indices (0-based).
 * Find the sum of the elements in nums from the indices at queries[i][0] to queries[i][1] (inclusive) for each query,
 * then add all of the sums for all the queries together. Return that number modulo 109 + 7.

 Example

 For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the output should be
 sumInRange(nums, queries) = 10.

 The array of results for queries is [1, 3, 6], so the answer is 1 + 3 + 6 = 10.
 */
public class SumInRange {

    int sumInRange1(int[] nums, int[][] queries) {
        int mod = 1000000007;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for(int i = 1; i < nums.length+1; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        Long sum = 0L;
        for(int i = 0; i < queries.length; i++) {
            sum += dp[queries[i][1]+1]-dp[queries[i][0]];
            sum%=mod;
        }

        return (int)((mod + sum)%mod);
    }

    int sumInRange2(int[] nums, int[][] queries) {
     int mod = 1000000007;
     int[][] dp = new int[nums.length][nums.length];

     for(int i = 0; i < nums.length; i++) {
         dp[i][i] = nums[i];
         for(int j = i+1; j < nums.length; j++) {
              dp[i][j] = (dp[i][j-1] + nums[j])%mod;
         }
     }
     Long sum = 0L;
     for(int i = 0; i < queries.length; i++) {
         sum += dp[queries[i][0]][queries[i][1]];
         sum%=mod;
     }

     return (int)((10*1000000007L + sum)%1000000007);
    }


}



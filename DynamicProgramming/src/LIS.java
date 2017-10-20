/**
 * Created by Tien on 10/18/2017.
 */
public class LIS {
    //Longest Increasing Subsequence
    public static int LIS(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }

        int[] dp = new int[len];

        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] +1, dp[i]);
                }
            }
        }

        int maxLength = 0;
        for(int i: dp) {
            if(i > maxLength) {
                maxLength = i;
            }
        }

        return maxLength;
    }

    //Longest Continuous Increasing Subsequence
    //Using DP
    public static int LCIS(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        int maxLength = 0;
        for(int i: dp){
            if(i > maxLength) {
                maxLength = i;
            }
        }

        return maxLength;
    }

    //Longest Continuous Increasing Subsequence
    //Using iteration
    public static int LCISiteration(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) {
            return 0;
        }

        int count = 1;
        int maxLength = 1;
        for(int i = 1; i < len; i++) {
            if(nums[i] > nums[i-1]) {
                count++;
                if(maxLength < count) {
                    maxLength = count;
                }
            } else {
                count = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("LIS [1,3,5,4,7]: " + LIS(new int[]{1,3,5,4,7}));
        System.out.println("LCIS [1,3,5,4,7]: " + LCIS(new int[]{1,3,5,4,7}));
        System.out.println("LCIS Iteration [1,3,5,6,7]: " + LCISiteration(new int[]{1,3,5,6,7,4}));
    }
}

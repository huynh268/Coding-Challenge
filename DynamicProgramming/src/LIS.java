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

    public static void main(String[] args) {
        System.out.println("LIS [1,3,5,4,7]: " + LIS(new int[]{1,3,5,4,7}));
    }
}

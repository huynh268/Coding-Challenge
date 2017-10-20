/**
 * Created by Tien on 10/19/2017.
 */
public class MinJumpToReachEnd {

    public static int[] minJumpToReachEnd(int[] a) {
        int len = a.length;

        if(a == null || len == 0) return null;

        int[] dp = new int[len];
        int[] steps = new int[len];

        dp[0] = 0;
        for(int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;

        for(int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                    steps[i] = Math.min(j, steps[i]);
                }
            }
        }

        int[] res = new int[] {dp[len-1]};
        return steps;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,2,4,2,0,1,1};
        System.out.println("#of steps to reach the end [2,3,1,1,2,4,2,0,1,1]:" );
        for(int i: minJumpToReachEnd(a)){
            System.out.print(i+ " ");
        }
    }
}

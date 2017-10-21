import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 10/20/2017.
 */
public class MaxSumSubsequence {

    //Maximum Sum Increasing Subsequence
    public static int[] maxSumIncreasingSubseqence(int[] a) {
        int len = a.length;

        if(a == null || len == 0)
            return null;

        int[] dp = new int[len];
        int[] steps = new int[len];

        //initialize dp - maximum sum value at index i
        for(int i = 0; i < len; i++) {
            dp[i] = a[i];
        }
        for(int i = 0; i < len; i++) {
            steps[i] = i;
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(a[j] < a[i]) {
                    dp[i] = Math.max(dp[j] + a[i], dp[i]);
                    steps[i] = (dp[j] + a[i]) < dp[i] ? steps[i] : j;
                }
            }
        }

        int maxSum = 0;
        for(int i: dp) {
            if(i > maxSum) {
                maxSum = i;
            }
        }
        return steps;
    }

    //Maximum Sum Subsequence Non-Adjacent
    //Using DP - O(n^2) time complexity - O(n) space
    public static int[] maxSumSubsequenceNonAdjacentDP(int[] a) {
        int len =  a.length;

        if(a == null || len == 0) {
            return null;
        }

        int[] dp = new int[len];
        int[] steps = new int[len];

        for(int i = 0; i < len; i++) {
            dp[i] = a[i];
        }

        for(int i = 0; i < len; i++) {
            steps[i] = i;
        }

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(j != i-1) {
                    dp[i] = Math.max(dp[j] + a[i], dp[i]);
                    steps[i] = (dp[j] + a[i]) < dp[i] ? steps[i] : j;
                }
            }
        }
        int maxSum = 0;
        for(int i: dp){
            if(i > maxSum){
                maxSum = i;
            }
        }

        List<Integer> l = new ArrayList<>();
        l.add(len-1);
        int m = len-1;
        while(m > 0){
            l.add(steps[m]);
            m = steps[m];
        }

        int[] res = new int[l.size()];
        for(int i = 0; i< l.size(); i++) {
            res[i] = l.get(l.size()-i-1);
        }

        return res;
    }

    //DP O(n) time complexity - 0(1) space
    public static int maxSumSubsequenceNonAdjacent(int[] a) {
        int incl = a[0]; //Sum including the previous element
        int excl = 0;    //Sum excluding the previous element

        for(int i = 1; i < a.length; i++) {
            int temp = incl;
            incl = Math.max(excl+a[i], incl); //incl = maximum of the sum before i which can include or exclude the previous element
            excl = temp;  //
        }
        return incl;
    }

    public static void main(String[] args){
        //System.out.println("MSIS of [4,6,1,3,8,4,6]: " + maxSumIncreasingSubseqence(new int[]{4,6,1,3,8,4,6}));
        //System.out.println("MSSNA of [4,1,1,4,2,1]: " + maxSumSubsequenceNonAdjacentDP(new int[]{4,1,1,4,2,1}));
        for(int i: maxSumIncreasingSubseqence(new int[]{4,6,1,3,8,4,6})) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i: maxSumSubsequenceNonAdjacentDP(new int[]{4,1,1,4,2,1})) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("MSSNA of [4,1,1,4,2,1]: " + maxSumSubsequenceNonAdjacent(new int[]{4,1,1,4,2,1}));
    }
}

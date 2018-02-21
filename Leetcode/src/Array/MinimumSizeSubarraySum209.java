package Array;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 */
public class MinimumSizeSubarraySum209 {

    /**
     * 2 Pointers
     * O(n) Time complexity
     * O(1) Space complex
     * @param s
     * @param nums
     * @return
     */
    int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int j = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                sum -= nums[j];
                min = min <  i-j+1 ? min : i-j+1;
                j++;
            }
        }
        return min ==  Integer.MAX_VALUE ? 0 : min;
    }
}

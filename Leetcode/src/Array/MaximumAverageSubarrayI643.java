package Array;

/**
 * Created by Tien on 2/19/2018.
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75

 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].
 */
public class MaximumAverageSubarrayI643 {

    /**
     * Prefix Sum
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @param k
     * @return
     */
    double findMaxAverage1(int[] nums, int k) {
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            preSum[i] = nums[i] + preSum[i-1];

        int max = preSum[k-1];
        for(int i = 1; i < nums.length - k + 1; i++) {
            int sum = preSum[i + k-1] - preSum[i-1];
            max = max > sum ? max : sum;
        }

        return (double)max/k;
    }

    /**
     * Sliding Window
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @param k
     * @return
     */
    double findMaxAverage2(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k ;i++) {
            sum += nums[i];
        }

        int max = sum;
        for(int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i-k];
            max = max > sum ? max : sum;
        }

        return (double)max/k;
    }
}

package Array;

/**
 * Created by Tien on 5/1/2018.
 *
 * https://leetcode.com/problems/continuous-subarray-sum/description/
 *
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
 * subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

 Example 1:
 Input: [23, 2, 4, 6, 7],  k=6
 Output: True
 Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

 Example 2:
 Input: [23, 2, 6, 4, 7],  k=6
 Output: True
 Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.

 Note:
 The length of the array won't exceed 10,000.
 You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */
public class ContinuousSubarraySum523 {

    /**
     * Prefix Sum
     * O(n^2) Time complexity
     * O(n) Space
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length+1];
        pre[0] = 0;
        for(int i = 1; i <= nums.length; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }

        for(int i = 2; i <= nums.length; i++) {
            for(int j = 0; j < i - 1; j++) {
                if((k != 0 &&(pre[i] - pre[j]) % k == 0) || k == 0 && pre[i] - pre[j] == 0)
                    return true;
            }
        }

        return false;
    }
}

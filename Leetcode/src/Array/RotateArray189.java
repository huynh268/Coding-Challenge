package Array;

/**
 * Created by Tien on 2/23/2018.
 *
 * https://leetcode.com/problems/rotate-array/description/
 *
 * Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class RotateArray189 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @param k
     */
    void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);
    }

    void reverse(int[] nums, int s, int e) {
        while(s < e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}

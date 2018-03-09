package Array;

/**
 * Created by Tien on 3/8/2018.
 *
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeroes283 {

    /**
     * O(n^2) Time complexity
     * O(1) Space
     * @param nums
     */
    void moveZeroes1(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) continue;
            int j = i + 1;
            while(j < nums.length && nums[j] == 0) {
                j++;
            }
            if(j < nums.length) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     */
    void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}

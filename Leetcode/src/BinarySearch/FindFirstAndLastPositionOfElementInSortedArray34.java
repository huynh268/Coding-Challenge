package BinarySearch;

/**
 * Created by Tien on 8/23/2018.
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1].

 Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]

 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public int[] searchRange(int[] nums, int target) {
        int left = modifiedBinary(nums, target, true);
        if(left == nums.length || nums[left] != target)
            return new int[]{-1,-1};

        int right = modifiedBinary(nums, target, false) - 1;

        return new int[]{left, right};
    }

    public int modifiedBinary(int[] nums, int target, boolean left) {
        int l = 0, r = nums.length;

        while(l < r) {
            int m = l + (r - l)/2;
            if(nums[m] > target || (left && nums[m] == target)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}

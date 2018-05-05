package BinarySearch;

/**
 * Created by Tien on 5/4/2018.
 *
 * https://leetcode.com/problems/search-for-a-range/description/
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
public class SearchForARange34 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[] {-1, -1};
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int middle = left + (right - left)/2;
            if()
        }
        return ans;
    }
}

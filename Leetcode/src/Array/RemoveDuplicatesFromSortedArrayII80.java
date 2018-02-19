package Array;

/**
 * Created by Tien on 2/18/2018.
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 *
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArrayII80 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n : nums) {
            if(i < 2 || nums[i - 2] < n) {
                nums[i++] = n;
            }
        }
        return i;
    }

    /**
     * Generalized solution for duplicates are allowed at most K times
     * O(n) Time complexity
     * O(1) Space
     * @param nums - the given sorted array
     * @param k - duplicates are allowed at most k times
     * @return
     */
    int removeDuplicatesK(int[] nums, int k) {
        int i = 0;
        for(int n : nums) {
            if(i < k || nums[i - k] < n) {
                nums[i++] = n;
            }
        }
        return i;
    }
}

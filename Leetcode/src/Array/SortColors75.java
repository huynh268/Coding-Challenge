package Array;

/**
 * Created by Tien on 3/23/2018.
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 */
public class SortColors75 {

    /**
     * Buble sort
     * O(N^2) Time complexity
     * O(1) Space
     * @param nums
     */
    public void sortColors1(int[] nums) {
        for(int i = 0; i < nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public void sortColors2(int[] nums) {

    }
}

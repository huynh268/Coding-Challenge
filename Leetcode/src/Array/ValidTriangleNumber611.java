package Array;

import java.util.Arrays;

/**
 * Created by Tien on 4/18/2018.
 *
 * https://leetcode.com/problems/valid-triangle-number/description/
 *
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles
 * if we take them as side lengths of a triangle.

 Example 1:
 Input: [2,2,3,4]
 Output: 3
 Explanation:
 Valid combinations are:
 2,3,4 (using the first 2)
 2,3,4 (using the second 2)
 2,2,3

 Note:
 The length of the given array won't exceed 1000.
 The integers in the given array are in the range of [0, 1000].
 */
public class ValidTriangleNumber611 {

    /**
     * O(n^2) Time complexity
     * O(logn) Space - Sorting takes O(logn) Space complexity
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 2; i < nums.length; i++) {
            int left = 0, right = i-1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    ans += left + right;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}

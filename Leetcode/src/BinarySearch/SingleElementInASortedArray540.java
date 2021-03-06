package BinarySearch;

/**
 * Created by Tien on 5/15/2018.
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 *
 * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

 Example 1:
 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2

 Example 2:
 Input: [3,3,7,7,10,11,11]
 Output: 10

 Note: Your solution should run in O(log n) time and O(1) space.


 */
public class SingleElementInASortedArray540 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    public int singleNonDuplicate1(int[] nums) {
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}

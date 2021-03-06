package Array;

import java.util.Arrays;

/**
 * Created by Tien on 3/13/2018.
 *
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.

 */
public class ShortestUnsortedContinuousSubarray581 {

    /**
     * Sorting
     * O(nlogn) Time complexity
     * O(n)Space
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        int start = 0, end = nums.length-1;
        while(start < nums.length && nums[start] == sortedNums[start]) start++;
        while(end > start && nums[end] == sortedNums[end]) end--;

        return end - start + 1;
    }
}

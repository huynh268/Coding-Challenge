package Array;

import java.util.HashMap;

/**
 * Created by Tien on 4/17/2018.
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

 Example 1:
 Input: [1, 2, 2, 3, 1]
 Output: 2
 Explanation:
 The input array has a degree of 2 because both elements 1 and 2 appear twice.
 Of the subarrays that have the same degree:
 [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 The shortest length is 2. So return 2.

 Example 2:
 Input: [1,2,2,3,1,4,2]
 Output: 6

 Note:
 nums.length will be between 1 and 50,000.
 nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray697 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> h = new HashMap<>();
        int maxCount = 1;
        int minRange = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(!h.containsKey(nums[i])) {
                int[] range = new int[] {1, i, i};
                h.put(nums[i], range);
            } else {
                int[] range = h.get(nums[i]);
                range[0]++;
                range[2] = i;
                h.put(nums[i], range);
                if(maxCount == range[0] && minRange > range[2] - range[1]) {
                    minRange = range[2] - range[1];
                }
                if(maxCount < range[0]) {
                    maxCount = range[0];
                    minRange = range[2] - range[1];
                }
            }
        }
        return (minRange == Integer.MAX_VALUE ? 0 : minRange) + 1;
    }
}

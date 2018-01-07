package Array;

import java.util.HashMap;

/**
 * Created by Tien on 1/6/2018.
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSum1 {
    /**
     * O(n) Time complexity - O(n) Space
     * @param nums
     * @param target
     * @return
     */
    int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                ans[0] = hashMap.get(nums[i]);
                ans[1] = i;
            } else {
                hashMap.put(target-nums[i], i);
            }
        }
        return ans;
    }
}

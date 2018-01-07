package Array;

import java.util.HashMap;

/**
 * Created by Tien on 1/6/2018.
 *
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII219 {

    boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                if (i - hm.get(nums[i]) <= k)
                    return true;
            }
            hm.put(nums[i], i);
        }
        return false;
    }
}
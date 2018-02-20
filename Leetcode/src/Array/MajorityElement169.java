package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Tien on 2/19/2018.
 *
 * https://leetcode.com/problems/majority-element/description/
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement169 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    int majorityElement1(int[] nums) {
        int l = nums.length/2;
        HashMap<Integer, Integer> hashMap =  new HashMap<>();

        for(int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
            if(hashMap.get(n) > l) return n;
        }
        return Integer.MAX_VALUE;
    }

    /**
     * O(nlogn) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

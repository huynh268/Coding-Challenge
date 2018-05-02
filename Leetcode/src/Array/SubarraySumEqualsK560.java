package Array;

import java.util.HashMap;

/**
 * Created by Tien on 4/17/2018.
 *
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

 Example 1:
 Input:nums = [1,1,1], k = 2
 Output: 2

 Note:
 The length of the array is in range [1, 20,000].
 The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK560 {

    /**
     * Prefix Sum
     * O(n^2) Time complexity
     * O(n) Space
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i < prefixSum.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i-1];

        int count = 0;
        for(int i = 1; i < prefixSum.length; i++) {
            for(int j = 0; j < i; j++) {
                if(prefixSum[i] - prefixSum[j] == k) count++;
            }
        }

        return count;
    }

    /**
     * Prefix Sum + Hashtable
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i < prefixSum.length; i++)
            prefixSum[i] = prefixSum[i-1] + nums[i-1];

        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < prefixSum.length; i++) {
            if(hashMap.containsKey(prefixSum[i] - k)) {
                count += hashMap.get(prefixSum[i] - k);
            }
            hashMap.put(prefixSum[i], hashMap.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }

    /**
     * Prefix Sum(without storing array) + Hashtable
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int count = 0;

        hashMap.put(0, 1); //nums[i] = k

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(hashMap.containsKey(sum - k)) {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}

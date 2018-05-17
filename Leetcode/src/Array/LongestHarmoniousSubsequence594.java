package Array;

import java.util.HashMap;

/**
 * Created by Tien on 5/15/2018.
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

 Example 1:
 Input: [1,3,2,2,5,2,3,7]
 Output: 5
 Explanation: The longest harmonious subsequence is [3,2,2,2,3].

 Note: The length of the input array will not exceed 20,000.


 */
public class LongestHarmoniousSubsequence594 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
            if(hashMap.containsKey(i - 1)) ans = Math.max(ans, hashMap.get(i) + hashMap.get(i - 1));
            if(hashMap.containsKey(i + 1)) ans = Math.max(ans, hashMap.get(i) + hashMap.get(i + 1));
        }

        return ans;
    }
}

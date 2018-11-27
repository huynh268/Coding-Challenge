package Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Tien on 5/17/2018.
 *
 * https://leetcode.com/problems/contiguous-array/description/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

 Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray525 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int max = 0;
        int[] val = new int[2*nums.length + 1];
        Arrays.fill(val, -2);
        int count = 0;
        val[nums.length] = -1;

        for(int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? 1 : -1;
            if(val[count + nums.length] > -2) {
                max = Math.max(max, i - val[count + nums.length]);
            } else {
                val[count + nums.length] = i;
            }
        }

        return max;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int findMaxLength1(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        //Start at 0 and index = -1;
        hm.put(0, -1);

        for(int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? 1 : -1;
            if(hm.containsKey(count)) {
                max = Math.max(max, i - hm.get(count));
            } else {
                hm.put(count, i);
            }
        }

        return max;
    }
}

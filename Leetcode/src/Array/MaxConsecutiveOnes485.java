package Array;

/**
 * Created by Tien on 1/5/2018.
 *
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.

 Example 1:
 Input: [1,1,0,1,1,1]
 Output: 3
 Explanation: The first two digits or the last three digits are consecutive 1s.
 The maximum number of consecutive 1s is 3.
 Note:

 The input array will only contain 0 and 1.
 The length of input array is a positive integer and will not exceed 10,000

 */
public class MaxConsecutiveOnes485 {

    int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;

        for(int n : nums) {
            if(n == 1) {
                count++;
                if(max < count) max = count;
            } else
                count = 0;
        }
        return max;
    }
}

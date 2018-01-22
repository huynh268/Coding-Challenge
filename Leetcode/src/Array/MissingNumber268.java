package Array;

/**
 * Created by Tien on 1/22/2018.
 *
 * https://leetcode.com/problems/missing-number/description/
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1

 Input: [3,0,1]
 Output: 2
 Example 2

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8
 */
public class MissingNumber268 {

    /**
     * O(n) Time complexity
     * O(1) Space
     *
     * sum(n) = 1+2+3+...+n = n*(n+1)/2
     *
     * @param nums
     * @return
     */
    int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;

        for(int i : nums)
            sum -= i;

        return sum;
    }
}

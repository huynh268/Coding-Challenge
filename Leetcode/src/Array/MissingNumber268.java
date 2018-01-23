package Array;

import java.util.Arrays;

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
     * Gauss's Formula
     * sum(n) = 1+2+3+...+n = n*(n+1)/2
     *
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int missingNumber1(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;

        for(int i : nums)
            sum -= i;

        return sum;
    }

    /**
     * Bit Manipulation
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int missingNumber2(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < nums.length; i++)
            n ^= i ^ nums[i];

        return n;
    }

    /**
     * Binary Search
     * O(nlogn) Time complexity - Sorting
     * O(1) Space
     * @param nums
     * @return
     */
    int missingNumber3(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length, middle;

        while(left < right) {
            middle = left + (right-left)/2;
            if(nums[middle] > middle) right = middle-1;
            else left = middle;
        }
        return left;
    }
}

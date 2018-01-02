package Array;

/**
 * Created by Tien on 1/1/2018.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 */
public class maxProduct152 {

    /**
     * Dynamic Programming - Similar to Kadane's Algorithm
     * O(n) Time Complexity - O(1) Space
     * @param nums
     * @return
     */
    int maxProduct(int[] nums) {
        int maxHere = nums[0], minHere = nums[0], max = nums[0];

        for(int i = 1; i <nums.length; i++) {
            int tmpMax = maxHere, tmpMin = minHere;
            maxHere = Math.max(tmpMax*nums[i], Math.max(tmpMin*nums[i], nums[i]));
            minHere = Math.min(tmpMax*nums[i], Math.min(tmpMin*nums[i], nums[i]));
            max = Math.max(max, maxHere);
        }

        return max;
    }
}

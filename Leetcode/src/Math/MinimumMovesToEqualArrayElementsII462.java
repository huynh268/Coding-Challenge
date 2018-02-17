package Math;

import java.util.Arrays;

/**
 * Created by Tien on 2/16/2018.
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 *
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

 You may assume the array's length is at most 10,000.

 Example:

 Input:
 [1,2,3]

 Output:
 2

 Explanation:
 Only two moves are needed (remember each move increments or decrements one element):

 [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovesToEqualArrayElementsII462 {

    /**
     * O(nlogn) Time complexity
     * O(1) Space
     *
     * For every set S, the median m of S minimizes the sum ∑s∈S|m - s|
     * @param nums
     * @return
     */
    int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int i = 0, j = nums.length-1;
        while(i < j) {
            ans += nums[j] - nums[i];
        }
        return ans;
    }
}

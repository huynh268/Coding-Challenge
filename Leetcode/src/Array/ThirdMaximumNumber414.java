package Array;

/**
 * Created by Tien on 2/16/2018.
 *
 * https://leetcode.com/problems/third-maximum-number/description/
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

 Example 1:
 Input: [3, 2, 1]

 Output: 1

 Explanation: The third maximum is 1.
 Example 2:
 Input: [1, 2]

 Output: 2

 Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 Example 3:
 Input: [2, 2, 3, 1]

 Output: 1

 Explanation: Note that the third maximum here means the third maximum distinct number.
 Both numbers with value 2 are both considered as second maximum.

 */
public class ThirdMaximumNumber414 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for(Integer i : nums) {
            if(i.equals(max1) || i.equals(max2) || i.equals(max3)) continue;
            if(i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if(i > max2) {
                max3 = max2;
                max2 = i;
            } else if(i > max3) {
                max3 = i;
            }
        }

        return max3 == null ? max1 : max3;
    }
}

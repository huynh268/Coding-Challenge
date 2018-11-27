package Array;

/**
 * Created by Tien on 8/29/2018.
 *
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 *
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Example 1:
 Input: [1,2,3,4,5]
 Output: true

 Example 2:
 Input: [5,4,3,2,1]
 Output: false
 */
public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i <= m1) {
                m1 = i;
            } else if(i < m2) {
                m2 = i;
            } else if(i > m2) {
                return  true;
            }
        }

        return false;
    }
}

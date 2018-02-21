package Array;

import java.util.Arrays;

/**
 * Created by Tien on 1/29/2018.
 *
 * https://leetcode.com/problems/3sum-closest/description/
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest16 {

    /**
     * O(n^2) Time complexity
     * O(1) Space
     * @param nums
     * @param target
     * @return
     */
    int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length-2; i++) {
            int l = i+1, r = nums.length-1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                    if(sum == 0) return ans;
                }
                if(sum > target) r--;
                else l++;
            }
        }
        return ans;
    }
}

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 1/29/2018.
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class ThreeSum15 {

    /**
     * O(n^2) Time complexity
     * O(1) Space
     * @param nums
     * @return
     */
    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1, r = nums.length-1;
            List<Integer> list = new ArrayList<>();
            while(l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(new ArrayList<>(list));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}

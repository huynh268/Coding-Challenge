package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 2/17/2018.
 *
 * https://leetcode.com/problems/4sum/description/
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.

 Note: The solution set must not contain duplicate quadruplets.

 For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class FourSum18 {

    /**
     * Backtracking
     * Time Limit Exceeded
     *
     * O(n^4) Time complexity- 1st number has n options, 2nd number has n-1,... Since there are 4 numbers, n(n-1)(n-2)(n-3) = O(n^4)
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    void dfs(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == 4) {
            if(target == 0) ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i <= nums.length - (4 - list.size()); i++) {
            if(i > start && nums[i] == nums[i-1]) continue;
            if(list.size() == 0 && 4*nums[i] > target) break;
            if(list.size() == 1 && 3*nums[i] > target) break;
            if(list.size() == 2 && 2*nums[i] > target) break;
            if(list.size() == 3 && nums[i] > target) break;
            list.add(nums[i]);
            dfs(nums, target - nums[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
    }

    /**
     * Based on 3sum
     * O(n^3) Time complexity
     *
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length <= 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int threeSum = target - nums[i];

            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int m = j + 1, n = nums.length - 1;
                List<Integer> list = new ArrayList<>();
                while(m < n) {
                    int sum = threeSum - nums[j] - nums[m] -  nums[n];
                    if(sum == 0) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        ans.add(new ArrayList<>(list));

                        m++;
                        n--;

                        while(m < n && nums[m] == nums[m-1]) m++;
                        while(m < n && nums[n] == nums[n+1]) n--;
                    } else if (sum < 0) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Generalized solution for K-Sum, K >= 2
     * @param nums
     * @param target
     * @return
     */
    List<List<Integer>> fourSum3(int[] nums, int target) {
        Arrays.sort(nums);

        return kSum(nums, target, 4, 0);
    }

    List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if(start >= nums.length) return ans;
        if(k == 2) {
            int i = start, j = nums.length-1;

            while(i < j) {
                int sum = nums[i] + nums[j];
                if(sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(new ArrayList(list));

                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i-1]) i++;
                    while(i < j && nums[j] == nums[j+1]) j--;
                } else if(sum > target) {
                    j--;
                } else {
                    i++;
                }
            }
        } else {
            for(int i = start; i < nums.length - k +1; i++) {
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                if(temp != null) {
                    for(List<Integer> l : temp) {
                        l.add(0, nums[i]);
                    }
                    ans.addAll(temp);
                }
                while(i < nums.length-1 && nums[i] == nums[i+1]) i++;
            }
        }
        return ans;
    }
}

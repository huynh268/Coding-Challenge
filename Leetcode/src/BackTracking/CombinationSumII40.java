package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 1/3/2018.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 - All numbers (including target) will be positive integers.
 - The solution set must not contain duplicate combinations.

 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSumII40 {

    List<List<Integer>> combinationSum2(int[] nums, int sum) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, sum, 0, new ArrayList<Integer>(), ans);

        return ans;
    }

    void backtrack(int[] nums, int sum, int start, List<Integer> list, List<List<Integer>> ans) {
        if(sum < 0) {
            return;
        } else if(sum == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for(int i = start; i < nums.length; i++) {
                if(i > start && nums[i] == nums[i-1])
                    continue;
                list.add(nums[i]);
                backtrack(nums, sum - nums[i], i+1, list, ans);
                list.remove(list.size()-1);
            }
        }
    }
}

package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 1/3/2018.
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 - All numbers (including target) will be positive integers.
 - The solution set must not contain duplicate combinations.

 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum39 {

    List<List<Integer>> combinationSum(int[] nums, int sum) {
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
                list.add(nums[i]);
                backtrack(nums, sum - nums[i], i, list, ans); //can use the same nums[i]
                list.remove(list.size()-1);
            }
        }
    }
}

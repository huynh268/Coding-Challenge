package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 12/30/2017.
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */
public class SubsetsII90 {

    List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            dfs(nums, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}

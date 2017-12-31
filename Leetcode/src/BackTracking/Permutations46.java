package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 12/30/2017.
 *
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations46 {

    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), result);
        return result;
    }

    void dfs(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));

        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs(nums, list, result);
            list.remove(list.size()-1);
        }
    }
}

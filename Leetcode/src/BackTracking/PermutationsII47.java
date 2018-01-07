package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 1/5/2018.
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class PermutationsII47 {

    List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<Integer>(), ans);
        return ans;
    }

    void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(visited[i] || i > 0 && nums[i-1] == nums[i] && visited[i-1])
                    continue;

                visited[i] = true;
                list.add(nums[i]);
                backtrack(nums, visited, list, ans);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}

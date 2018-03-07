package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 12/30/2017.
 *
 * https://leetcode.com/problems/permutations/description/
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

    /**
     * O(n!) Time complexity
     * O(n!) Space
     * @param nums
     * @return
     */
    List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs1(nums, new ArrayList<>(), result);
        return result;
    }

    void dfs1(int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length)
            result.add(new ArrayList<>(list));

        for(int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            dfs1(nums, list, result);
            list.remove(list.size()-1);
        }
    }

    /**
     * O(n!) Time complexity
     * O(n!) Space
     * @param nums
     * @return
     */
    List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs2(nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    void dfs2(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }

        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs2(nums, visited, list, ans);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

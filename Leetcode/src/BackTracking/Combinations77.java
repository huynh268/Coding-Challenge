package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 3/5/2018.
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class Combinations77 {

    /**
     * O(C(n,k)) Time complexity, C(n,k) = n!/(k!(n-k)!)
     * O(C(n,k)) Space
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), ans);
        return ans;
    }

    void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>> ans) {
        if(list.size() == k) {
            ans.add(new ArrayList(list));
            return;
        }
        for(int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}

package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 3/5/2018.
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


 Example 1:
 Input: k = 3, n = 7
 Output:
 [[1,2,4]]

 Example 2:
 Input: k = 3, n = 9
 Output:
 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII216 {

    /**
     * O(C(9,k)) Time complexity, where C(9, k) = 9!(k!(9-k)!)
     * O(C(9,k)) Space
     * @param k
     * @param n
     * @return
     */
    List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), ans);
        return ans;
    }

    void dfs(int k, int n, int start, List<Integer> list, List<List<Integer>> ans) {
        if(n < 0) return;
        if(list.size() == k) {
            if(n == 0) ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i <= 9; i++) {
            list.add(i);
            dfs(k, n - i, i + 1, list, ans);
            list.remove(list.size()-1);
        }
    }
}

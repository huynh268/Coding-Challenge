package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by Tien on 12/20/2017.
 *
 * Given a sorted array of integers arr and an integer num, find all possible unique subsets of arr that add up to num.
 * Both the array of subsets and the subsets themselves should be sorted in lexicographical order.

 Example

 For arr = [1, 2, 3, 4, 5] and num = 5, the output should be
 sumSubsets(arr, num) = [[1, 4], [2, 3], [5]].
 */
public class SumSubsets {

    int[][] sumSubsets(int[] arr, int num) {
        if(arr.length == 0)
            return new int[1][0];

        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        solve(arr, 0, num, subset, result);

        return result.stream()
                .map(l->l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    void solve(int[] arr, int index, int sum, List<Integer> subset, List<List<Integer>> result) {
        if(sum < 0) return;
        if(sum == 0 && !result.contains(new ArrayList<>(subset))) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            subset.add(arr[i]);
            solve(Arrays.copyOfRange(arr, i+1, arr.length), i+1, sum - arr[i], subset, result);
            subset.remove(subset.size()-1);
        }
    }
}

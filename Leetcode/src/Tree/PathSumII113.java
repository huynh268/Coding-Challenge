package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 2/10/2018.
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \    / \
  7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII113 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    /**
     * DFS - Backtracking
     * Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param sum
     * @return
     */
    List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == sum) ans.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null) {
            dfs(root.left, sum - root.val, path, ans);
            path.remove(path.size() - 1);
        }
        if(root.right != null) {
            dfs(root.right, sum - root.val, path, ans);
            path.remove(path.size() - 1);
        }
    }
}

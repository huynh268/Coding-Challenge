package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs1(root, sum, new ArrayList<>(), ans);
        return ans;
    }

    void dfs1(TreeNode root, int sum, List<Integer> path, List<List<Integer>> ans) {
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == sum) ans.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null) dfs1(root.left, sum - root.val, path, ans);
        if(root.right != null) dfs1(root.right, sum - root.val, path, ans);

        path.remove(path.size() - 1);

    }

    /**
     * DFS
     * Recursive - Stack
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param sum
     * @return
     */
    List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs2(root, sum, new Stack<>(), ans);
        return ans;
    }

    void dfs2(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> ans) {
        path.push(root.val);

        if(root.left == null && root.right == null) {
            if(root.val == sum) ans.add(new ArrayList<>(path));
            return;
        }

        if(root.left != null) {
            dfs2(root.left, sum - root.val, path, ans);
            path.pop();
        }
        if(root.right != null) {
            dfs2(root.right, sum - root.val, path, ans);
            path.pop();
        }
    }

    /**
     * Iterative - Stack - Post-order Traversal
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param sum
     * @return
     */
    List<List<Integer>> pathSum3(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Integer> path = new Stack<>();
        path.push(root.val);
        TreeNode currentNode = null;
        TreeNode previousNode = null;

        while(!path.isEmpty()) {
            currentNode = path.pop();
        }

        return ans;
    }
}

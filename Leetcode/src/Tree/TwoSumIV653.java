package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.HashSet;

/**
 * Created by Tien on 3/8/2018.
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7
 Target = 9
 Output: True

 Example 2:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7
 Target = 28
 Output: False
 */
public class TwoSumIV653 {
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
     * DFS + HashSet
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            if(hashSet.contains(root.val)) return true;
            hashSet.add(k - root.val);
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return false;
    }

    /**
     * DFS Recursive + HashSet
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        return dfs(root, k, hashSet);
    }

    boolean dfs(TreeNode root, int k, HashSet<Integer> hashSet) {
        if(root == null) return false;
        if(hashSet.contains(root.val)) return true;
        hashSet.add(k - root.val);
        return dfs(root.left, k, hashSet) || dfs(root.right, k, hashSet);
    }

    /**
     * BFS + HashSet
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    boolean findTarget3(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            root = queue.poll();
            if(hashSet.contains(root.val)) return true;
            hashSet.add(k - root.val);
            if(root.left != null) queue.offer(root.left);
            if(root.right != null) queue.offer(root.right);
        }
        return false;
    }
}

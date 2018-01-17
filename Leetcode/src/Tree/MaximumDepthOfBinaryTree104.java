package Tree;

/**
 * Created by Tien on 1/16/2018.
 *
 *https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree104 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }

    int maxDepth2(TreeNode root) {

    }
}

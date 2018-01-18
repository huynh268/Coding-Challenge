package Tree;

/**
 * Created by Tien on 1/17/2018.
 *
 *https://leetcode.com/problems/balanced-binary-tree/description/
 *
 * Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree110 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    int treeDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(treeDepth(root.right), treeDepth(root.left));
    }
}

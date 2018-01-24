package Tree;

import java.util.Stack;

/**
 * Created by Tien on 1/23/2018.
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

 Example:

 Input:

    1
     \
      3
     /
    2

 Output:
 1

 Explanation:
 The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceInBST530 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    int getMinimumDifference1(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previousNode = null;

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(previousNode != null) min = Math.min(min, root.val - previousNode.val);
            previousNode = root;
            root = root.right;
        }
        return min;
    }


    int min = Integer.MIN_VALUE;
    TreeNode prev = null;
    int getMinimumDifference2(TreeNode root) {
        if(root == null) return min;

        getMinimumDifference2(root.left);
        if(prev != null) Math.min(min, root.val - prev.val);
        prev = root;
        getMinimumDifference2(root.right);

        return min;
    }
}

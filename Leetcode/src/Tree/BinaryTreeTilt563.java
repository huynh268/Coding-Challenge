package Tree;

/**
 * Created by Tien on 2/9/2018.
 *
 * https://leetcode.com/problems/binary-tree-tilt/description/
 *
 * Given a binary tree, return the tilt of the whole tree.

 The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values.
 Null node has tilt 0.

 The tilt of the whole tree is defined as the sum of all nodes' tilt.

 Example:
 Input:
 1
 /   \
 2     3
 Output: 1
 Explanation:
 Tilt of node 2 : 0
 Tilt of node 3 : 0
 Tilt of node 1 : |2-3| = 1
 Tilt of binary tree : 0 + 0 + 1 = 1
 Note:

 The sum of node values in any subtree won't exceed the range of 32-bit integer.
 All the tilt values won't exceed the range of 32-bit integer.

 */
public class BinaryTreeTilt563 {
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
     * O(n) Time complexity
     * O(n) Space
     */
    int tilt = 0;
    int findTilt1(TreeNode root) {
        helper(root);
        return tilt;
    }

    //Post-order traversal
    int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        tilt += Math.abs(left - right);
        return root.val + left + right;
    }

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int findTilt2(TreeNode root) {
        if(root == null) return 0;
        return Math.abs(sumSubtree(root.left) - sumSubtree(root.right)) + findTilt2(root.left) + findTilt2(root.right);
    }

    int sumSubtree(TreeNode root) {
        if(root == null) return 0;
        return root.val + sumSubtree(root.left) + sumSubtree(root.right);
    }
}

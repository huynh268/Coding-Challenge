package Tree;

/**
 * Created by Tien on 1/17/2018.
 *
 *
 *
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree111 {
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
     * @param root
     * @return
     */
    int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null || root.right == null)
            return 1 + minDepth(root.left) + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

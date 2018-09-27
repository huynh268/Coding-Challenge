package Tree;

/**
 * Created by Tien on 9/25/2018.
 *
 *
 *
 * Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 The path must contain at least one node and does not need to go through the root.

 Example 1:
 Input: [1,2,3]

   1
  / \
 2   3

 Output: 6

 Example 2:
 Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

 Output: 42
 */
public class BinaryTreeMaximumPathSum124 {
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
     * Time complexity: O(n) - visit each node once
     * Space complexity: O(n)
     * @param root
     * @return
     */
    int max = Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}

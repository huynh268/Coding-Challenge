package Tree;

import java.util.Stack;

/**
 * Created by Tien on 2/14/2018.
 *
 *
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.

 Example:

 Input: The root of a Binary Search Tree like this:
    5
  /   \
 2     13

 Output: The root of a Greater Tree like this:
     18
   /   \
 20     13

 */
public class ConvertBSTtoGreaterTree538 {
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
     * Reverse Inorder Traversal - Recursive
     * O(N) Time complexity
     * O(N) Space
     * @param root
     * @return
     */
    int sum = 0;
    TreeNode convertBST1(TreeNode root) {
        reverseInorderTraversal(root);
        return root;
    }

    void reverseInorderTraversal(TreeNode root) {
        if(root != null) {
            if(root.right != null) reverseInorderTraversal(root.right);
            sum += root.val;
            root.val = sum;
            if(root.left != null) reverseInorderTraversal(root.left);
        }
    }

    /**
     * Reverse Inorder Traversal - Iterative
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    TreeNode convertBST2(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = root;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            sum += root.val;
            root.val = sum;
            root = root.left;
        }
        return ans;
    }
}

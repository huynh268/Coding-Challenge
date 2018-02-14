package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 2/13/2018.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

 Example 1:
   2
  / \
 1   3
 Binary tree [2,1,3], return true.

 Example 2:
   1
  / \
 2   3
 Binary tree [1,2,3], return false.

 */
public class ValidateBinarySearchTree98 {
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
    boolean isValidBST1(TreeNode root) {
        List<Integer> sortedList = inorderTraversal(root);
        for(int i = 1; i < sortedList.size(); i++) {
            if(sortedList.get(i-1) >= sortedList.get(i)) return false;
        }
        return true;
    }

    List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            if (root.left != null) ans.addAll(inorderTraversal(root.left));
            ans.add(root.val);
            if (root.right != null) ans.addAll(inorderTraversal(root.right));
        }
        return ans;
    }

    /**
     * Recursive
     * Inorder Traversal
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    Integer pre = null;
    boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            if(!isValidBST2(root.left)) return false;
            if(pre != null && pre >= root.val) return false;
            pre = root.val;
            return isValidBST2(root.right);
        }
    }

    /**
     * Iterative
     * Inorder Traversal
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    boolean isValidBST3(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

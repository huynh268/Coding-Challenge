package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 1/2/2018.
 *
 * https://leetcode.com/problems/invert-binary-tree/description/
 *
 * Invert a binary tree.
      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 to

      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 */
public class InvertTree226 {
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
     * Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    TreeNode invertTree1(TreeNode root) {
        if(root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null) invertTree1(root.left);
            if(root.right != null) invertTree1(root.right);
        }
        return root;
    }

    /**
     * Iterative - Queue
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    TreeNode invertTree2(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            TreeNode tmp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tmp;

            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }

        return root;
    }

    /**
     *  Iterative - Stack
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    TreeNode invertTree3(TreeNode root) {
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            TreeNode tmp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tmp;

            if(currentNode.left != null) stack.push(currentNode.left);
            if(currentNode.right != null) stack.push(currentNode.right);
        }

        return root;
    }
}

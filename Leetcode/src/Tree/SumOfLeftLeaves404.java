package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 3/4/2018.
 *
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 *
 * Find the sum of all left leaves in a given binary tree.

 Example:

   3
  / \
 9  20
   /  \
  15   7

 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves404 {
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
     * BFS
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int sumOfLeftLeaves1(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
            if(root.left != null) queue.offer(root.left);
            if(root.right != null) queue.offer(root.right);
        }

        return sum;
    }

    /**
     * DFS - Iterative
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int sumOfLeftLeaves2(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }

        return sum;
    }
}

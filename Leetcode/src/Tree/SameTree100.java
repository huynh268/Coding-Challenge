package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 1/10/2018.
 *
 *https://leetcode.com/problems/same-tree/description/
 *
 * Given two binary trees, write a function to check if they are the same or not.

 Two binary trees are considered the same if they are structurally identical and the nodes have the same value.


 Example 1:
 Input:      1         1
            / \       / \
           2   3     2   3

 [1,2,3],   [1,2,3]
 Output: true

 Example 2:
 Input:      1         1
            /           \
           2             2

 [1,2],     [1,null,2]
 Output: false

 Example 3:
 Input:     1         1
           / \       / \
          2   1     1   2

 [1,2,1],   [1,1,2]
 Output: false
 */
public class SameTree100 {
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
     * O(n) Time complexity - Visit each node once
     * O(n) Space
     * @param p
     * @param q
     * @return
     */
    boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        return p.val == q.val && isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    /**
     * Iterative - Stack
     * O(n) Amortized time complexity - Visit each node twice
     * O(n) Space
     * @param p
     * @param q
     * @return
     */
    boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            stack.push(t1.left);
            stack.push(t2.left);
            stack.push(t1.right);
            stack.push(t2.right);
        }

        return true;
    }

    /**
     * Iterative - Queue
     * O(n) Amortized time complexity
     * O(n) Space
     * @param p
     * @param q
     * @return
     */
    boolean isSameTree3(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            queue.add(t1.left);
            queue.add(t2.left);
            queue.add(t1.right);
            queue.add(t2.right);
        }

        return true;
    }
}

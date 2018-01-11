package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 1/10/2018.
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

     1
    / \
   2   2
  / \  / \
 3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
     1
    / \
   2   2
   \   \
   3    3
 */
public class SymmetricTree101 {
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
     * O(n) Time complexity - Since we traverse each node once. The number of recursive calls is bounded by the height of the tree.
     *                          In the worst case when the tree is linear and height is O(n)
     * O(n) Space - In worst case, there are n recursive calls which are stored in n stacks
     * @param root
     * @return
     */
    boolean isSymmetric1(TreeNode root) {
        return check(root, root);
    }

    boolean check(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;


        return t1.val == t2.val && check(t1.left, t2.right) && check(t1.right, t2.left);
    }

    /**
     * Iterative - Queue
     * @param root
     * @return
     */
    boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }

    /**
     * Iterative - Stack
     * @param root
     * @return
     */
    boolean isSymmertric3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();

            if(t1 == null && t2 == null) continue;
            if(t1 == null || t2 == null) return false;
            if(t1.val != t2.val) return false;

            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }

        return true;
    }
}

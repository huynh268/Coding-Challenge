package Tree;

/**
 * Created by Tien on 3/1/2018.
 *
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

 An example is the root-to-leaf path 1->2->3 which represents the number 123.

 Find the total sum of all root-to-leaf numbers.

 For example,

   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.

 Return the sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers129 {
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
     * DFS - Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    int sum(TreeNode root, int s) {
        if(root == null) return s;
        s = s*10 + root.val;
        if(root.left == null && root.right ==null) return s*10 + root.val;
        return sum(root.left, s) + sum(root.right, s);
    }
}

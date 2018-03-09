package Tree;

import java.util.Stack;
import java.util.HashSet;

/**
 * Created by Tien on 3/8/2018.
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7
 Target = 9
 Output: True

 Example 2:
 Input:
     5
    / \
   3   6
  / \   \
 2   4   7
 Target = 28
 Output: False
 */
public class TwoSumIV653 {
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
     * @param k
     * @return
     */
    boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()) {
            root = s.pop();
            if(hashSet.contains(root.val)) return true;
            hashSet.add(k - root.val);
            if(root.left != null) s.push(root.left);
            if(root.right != null) s.push(root.right);
        }
        return false;
    }
    
}

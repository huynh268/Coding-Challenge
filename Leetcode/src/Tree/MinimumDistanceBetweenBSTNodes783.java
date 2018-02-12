package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 2/11/2018.
 *
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

 Example :

 Input: root = [4,2,6,1,3,null,null]
 Output: 1
 Explanation:
 Note that root is a TreeNode object, not an array.

 The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

      4
    /  \
   2    6
  / \
 1   3

 while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

 Note:
 1 - The size of the BST will be between 2 and 100.
 2 - The BST is always valid, each node's value is an integer, and each node's value is different.

 */
public class MinimumDistanceBetweenBSTNodes783 {
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
     * Inorder traversal
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> sortedList = inorderTraversal(root);
        for(int i = 1; i < sortedList.size(); i++) {
            min = Math.min(min, sortedList.get(i) - sortedList.get(i-1));
        }
        return min;
    }

    List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root != null) {
            if(root.left != null) list.addAll(inorderTraversal(root.left));
            list.add(root.val);
            if(root.right != null) list.addAll(inorderTraversal(root.right));
        }
        return list;
    }
}

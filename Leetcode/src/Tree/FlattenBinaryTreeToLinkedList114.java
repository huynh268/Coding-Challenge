package Tree;

/**
 * Created by Tien on 4/3/2018.
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * Given a binary tree, flatten it to a linked list in-place.

 For example,
 Given

     1
    / \
   2   5
  / \   \
 3   4   6
 The flattened tree should look like:
 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
 */
public class FlattenBinaryTreeToLinkedList114 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public void flatten1(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten1(left);
        flatten1(right);

        root.left = null;
        root.right = left;

        TreeNode currentNode = root;
        while(currentNode.right != null) currentNode = currentNode.right;

        currentNode.right = right;
    }
}

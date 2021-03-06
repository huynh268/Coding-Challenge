package Tree;

/**
 * Created by Tien on 5/22/2018.
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

      _______6______
     /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
      /  \
     3   5
 Example 1:
 Input: root, p = 2, q = 8
 Output: 6
 Explanation: The LCA of nodes 2 and 8 is 6.

 Example 2:
 Input: root, p = 2, q = 4
 Output: 2
 Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 according to the LCA definition.
 */
public class LowestCommonAncestorOfBinarySearchTree235 {

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
     * O(n) Space - Stack for recursion calls
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor1(root.left, p, q);
        TreeNode r = lowestCommonAncestor1(root.right,p, q);

        if(l == null) return r;
        if(r == null) return l;
        return root;
    }

    /**
     * O(n) Time complexity
     * O(n) Space - Stack for recursion calls
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root == p || root == q) return root;
        TreeNode curNode = root;
        while(curNode != null) {
            if(curNode == p || curNode == q) return curNode;
            if(curNode.val < p.val && curNode.val < q.val) curNode = curNode.right;
            if(curNode.val >= p.val && curNode.val >= q.val) curNode = curNode.left;
            else return curNode;
        }
        return curNode;
    }

    /**
     * O(n) Time complexity
     * O(n) Space - Stack for recursion calls
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root == p || root == q) return root;
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor3(root.right, p, q);
        if(root.val >= p.val && root.val >= q.val) return lowestCommonAncestor3(root.left, p, q);
        return root;
    }
}

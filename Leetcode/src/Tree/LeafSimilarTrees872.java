package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 8/27/2018.
 *
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 Note:
 Both of the given trees will have between 1 and 100 nodes.

 */
public class LeafSimilarTrees872 {
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
     * DFS - Iteration
     *
     * Time complexity: O(r1 + r2)
     * Space complexity: O(r1 + r2)
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = dfs1(root1);
        List<Integer> leaves2 = dfs1(root2);

        return leaves1.equals(leaves2);
    }

    public List<Integer> dfs1(TreeNode root) {
        List<Integer> leaf = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            if(root.left == null && root.right == null) {
                leaf.add(root.val);
            }
            if(root.left != null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }

        return leaf;
    }


    /**
     * DFS - Recursion
     *
     * Time complexity: O(r1 + r2)
     * Space complexity: O(r1 + r2)
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs2(root1, leaves1);
        dfs2(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    public void dfs2(TreeNode root, List<Integer> leaf) {
        if(root.left == null && root.right == null) {
            leaf.add(root.val);
        }
        if(root.left != null) dfs2(root.left, leaf);
        if(root.right != null) dfs2(root.right, leaf);
    }
}

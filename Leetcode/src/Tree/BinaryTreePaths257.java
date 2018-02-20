package Tree;

import java.util.*;

/**
 * Created by Tien on 2/19/2018.
 *
 *
 *
 * Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

    1
  /   \
 2     3
  \
   5
 All root-to-leaf paths are:

 ["1->2->5", "1->3"]
 */
public class BinaryTreePaths257 {
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
    List<String> binaryTreePaths1(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, "", ans);
        return ans;
    }

    void dfs(TreeNode root, String path, List<String> ans) {
        if(root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        } else {
            if(root.left != null) dfs(root.left, path + root.val + "->", ans);
            if(root.right != null) dfs(root.right, path + root.val + "->", ans);
        }
    }

    /**
     * DFS - Iterative
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    List<String> binaryTreePaths2(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> nodes = new Stack<>();
        Stack<String> paths = new Stack<>();
        nodes.push(root);
        paths.push("");

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            String path = paths.pop();
            if(node.left == null && node.right == null) {
                ans.add(path + node.val);
            }

            if(node.left != null) {
                nodes.push(node.left);
                paths.push(path + node.val + "->");
            }
            if(node.right != null) {
                nodes.push(node.right);
                paths.push(path + node.val +"->");
            }
        }
        return ans;
    }

    /**
     * BFS - Iterative
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    List<String> binaryTreePaths3(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<String> paths = new LinkedList<>();
        nodes.add(root);
        paths.add("");

        while(!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            String path = paths.remove();

            if(node.left == null && node.right == null) {
                ans.add(path + node.val);
            }

            if(node.left != null) {
                nodes.add(node.left);
                paths.add(path + node.val + "->");
            }

            if(node.right != null) {
                nodes.add(node.right);
                paths.add(path + node.val + "->");
            }
        }
        return ans;
    }

    /**
     * Recursive
     * O(nlogn) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    List<String> binaryTreePaths4(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;

        if(root.left == null && root.right == null) {
            ans.add(root.val +"");
        }

        for(String s : binaryTreePaths4(root.left)) {
            ans.add(root.val + "->" + s);
        }

        for(String s : binaryTreePaths4(root.right)) {
            ans.add(root.val + "->" + s);
        }

        return ans;
    }
}

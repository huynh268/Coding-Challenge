package Tree;

import java.util.*;

/**
 * Created by Tien on 3/2/2018.
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 For example:
 Given the following binary tree,
     1            <---
   /   \
  2     3         <---
   \     \
    5     4       <---
 You should return [1, 3, 4].
 */
public class BinaryTreeRightSideView199 {
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
    List<Integer> rightSideView1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                root = queue.poll();
                if(size == 1) ans.add(root.val);
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                size--;
            }
        }

        return ans;
    }

    /**
     * DFS - Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int height = 0;
    List<Integer> rightSideView2(TreeNode root) {
        List<Integer> ans =  new ArrayList<>();
        if(root == null) return ans;
        dfs(root, 1, ans);
        return ans;
    }

    void dfs(TreeNode root, int depth, List<Integer> ans) {
        if(root == null) return;
        if(depth > height) {
            ans.add(root.val);
            height = depth;
        }
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
}

package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Tien on 3/1/2018.
 *
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 *
 * Given a binary tree, find the leftmost value in the last row of the tree.

 Example 1:
 Input:
   2
  / \
 1   3

 Output:
 1

 Example 2:
 Input:
     1
    / \
   2   3
  /   / \
 4   5   6
    /
   7

 Output:
 7

 Note: You may assume the tree (i.e., the given root node) is not NULL.
 */
public class FindBottomLeftTreeValue513 {
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
     * BFS - Traverse from Left to Right
     * Remember the 1st node of each level
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int findBottomLeftValue1(TreeNode root) {
        int ans = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            ans = queue.peek().val;
            while(size > 0) {
                root = queue.poll();
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                size--;
            }
        }

        return ans;
    }

    /**
     * BFS - Traverse from Right to Left
     * No need to remember the 1st node of each level, return the last node in the queue
     * @param root
     * @return
     */
    int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        return root.val;
    }

    /**
     * DFS
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int findBottomLeftValue3(TreeNode root) {
        int ans = root.val;
        int height = 0;
        dfs(root, 1, height, ans);
        return ans;
    }

    void dfs(TreeNode root, int depth, int height, int ans) {
        if(root == null) return;

        if(depth > height) {
            ans = root.val;
            height = depth;
        }

        dfs(root.left, depth + 1, height, ans);
        dfs(root.right, depth + 1, height, ans);
    }
}

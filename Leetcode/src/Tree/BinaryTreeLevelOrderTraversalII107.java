package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 2/21/2018.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
     3
    / \
   9  20
     /  \
    15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class BinaryTreeLevelOrderTraversalII107 {
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
     * O(N) Time complexity
     * O(N) Space
     * @param root
     * @return
     */
    List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size == 0) break;

            List<Integer> list = new ArrayList<>();
            while(size > 0) {
                root = queue.poll();
                list.add(root.val);
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                size--;
            }

            ans.add(0, list);
        }
        return ans;
    }
}

package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tien on 2/21/2018.
 *
 *
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class BinaryTreeLevelOrderTraversal102 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while(!deque.isEmpty()) {
            int size = deque.size();
            if(size == 0) break;
            List<Integer> list = new ArrayList<>();

            while(size > 0) {
                root = deque.poll();
                list.add(root.val);
                if(root.left != null) deque.offer(root.left);
                if(root.right != null) deque.offer(root.right);
                size--;
            }
            ans.add(list);
        }
        return ans;
    }
}

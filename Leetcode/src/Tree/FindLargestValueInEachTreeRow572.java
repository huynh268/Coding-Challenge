package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 3/1/2018.
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * You need to find the largest value in each row of a binary tree.

 Example:
 Input:

     1
    / \
   3   2
  / \   \
 5   3   9

 Output: [1, 3, 9]

 */
public class FindLargestValueInEachTreeRow572 {
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
    List<Integer> largestValues1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            while(size > 0) {
                root = queue.poll();
                max = max > root.val ? max : root.val;
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                size--;
            }
            ans.add(max);
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
    List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, 0, ans);
        return ans;
    }

    void dfs(TreeNode root, int depth, List<Integer> ans) {
        if(root == null) return;

        //Expand the list - Move to the next level of the tree
        if(depth == ans.size()) {
            ans.add(root.val);
        } else {
            //Check the current max value of level-depth and the current node value
            ans.set(depth, Math.max(ans.get(depth), root.val));
        }

        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);
    }
}

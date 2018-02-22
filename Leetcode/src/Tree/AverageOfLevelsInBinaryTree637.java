package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 2/21/2018.
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 Example 1:
 Input:
   3
  / \
 9  20
   /  \
  15   7
 Output: [3, 14.5, 11]
 Explanation:
 The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 Note:
 The range of node's value is in the range of 32-bit signed integer.
 */
public class AverageOfLevelsInBinaryTree637 {
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
     * BFS - Level Order Traversal
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int i = size;
            double sum = 0;
            while(i > 0) {
                root = queue.poll();
                sum += root.val;
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);
                i--;
            }
            ans.add(sum/size);
        }

        return ans;
    }
}

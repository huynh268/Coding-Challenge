package Tree;

import java.util.HashMap;

/**
 * Created by Tien on 2/22/2018.
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

 Determine the maximum amount of money the thief can rob tonight without alerting the police.

 Example 1:
     3
    / \
   2   3
   \   \
    3   1
 Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

 Example 2:
       3
      / \
     4   5
    / \   \
   1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII337 {
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
     * Recursive
     * O(2^n) Time complexity
     * O(2^n) space
     * @param root
     * @return
     */
    int rob1(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null) {
            sum += rob1(root.left.left) + rob1(root.left.right);
        }
        if(root.right != null) {
            sum += rob1(root.right.left) + rob1(root.right.right);
        }
        return Math.max(sum + root.val, rob1(root.left) + rob1(root.right));
    }

    /**
     * Recursive - Optimizing rob1
     * Using Hashtable to store solution of sub-problems
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    HashMap<TreeNode, Integer> hashMap = new HashMap<>();
    int rob2(TreeNode root) {
        if(root == null) return 0;
        if(hashMap.containsKey(root)) return hashMap.get(root);
        int sum = 0;
        if(root.left != null) {
            sum += rob2(root.left.left) + rob2(root.left.right);
        }
        if(root.right != null) {
            sum += rob2(root.right.left) + rob2(root.right.right);
        }
        int value = Math.max(root.val + sum, rob2(root.left) + rob2(root.right));
        hashMap.put(root, value);
        return value;
    }

    /**
     * DP - Recursive
     * O(n) Time complexity
     * O(n) Space
     *
     * ans[0] = root is not robbed - exclude root.val, then check for its children - root.left and root.right
     * ans[1] = root is robbed - include root.val, then check for its grandchildren - root.left.left, root.left.right, root.right.left, and root.right.right
     * @param root
     * @return
     */
    int rob3(TreeNode root) {
        if(root == null) return 0;
        int[] ans = robHelper(root);
        return Math.max(ans[0], ans[1]);
    }

    int[] robHelper(TreeNode root) {
        int[] ans = new int[2];
        if(root == null)
            return ans;

        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //Exclude root.val
        ans[1] = root.val + left[0] + right[0]; //Include root.val
        return ans;
    }
}

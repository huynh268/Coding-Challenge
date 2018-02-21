package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Tien on 2/21/2018.
 *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

 The root is the maximum number in the array.
 The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 Construct the maximum tree by the given array and output the root node of this tree.

 Example 1:
 Input: [3,2,1,6,0,5]
 Output: return the tree root node representing the following tree:

    6
  /   \
 3     5
 \    /
  2  0
  \
  1
 Note:
 The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree654 {
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
     * O(n^2) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    TreeNode constructMaximumBinaryTree1(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return constructTree(nums, 0, nums.length-1);
    }

    TreeNode constructTree(int[] nums, int s, int e) {
        if(s > e) {
            return null;
        } else {
            int i = max(nums, s, e);
            TreeNode root = new TreeNode(nums[i]);
            root.left = constructTree(nums, s, i - 1);
            root.right = constructTree(nums, i + 1, e);
            return root;
        }
    }

    int max(int[] nums, int s, int e) {
        int ans = s;
        for(int i = s; i <= e; i++) {
            if(nums[ans] < nums[i]) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param nums
     * @return
     */
    TreeNode constructMaximumBinaryTree2(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        Deque<TreeNode> deque = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            TreeNode currentNode = new TreeNode(nums[i]);
            while(!deque.isEmpty() && deque.peek().val < nums[i]) {
                currentNode.left = deque.peek();
                deque.pop();
            }

            if(!deque.isEmpty()) {
                deque.peek().right = currentNode;
            }

            deque.push(currentNode);
        }

        return deque.peekLast();
    }
}

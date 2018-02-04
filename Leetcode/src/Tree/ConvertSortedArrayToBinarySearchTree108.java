package Tree;

/**
 * Created by Tien on 2/3/2018.
 *
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

        0
       / \
     -3   9
     /   /
   -10  5

 */
public class ConvertSortedArrayToBinarySearchTree108 {
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
     * O(n) Time comeplexity
     * O(n) Space
     * @param nums
     * @return
     */
    TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = helper(nums, start, mid-1);
        t.right = helper(nums, mid+1, end);
        return t;
    }
}

package Tree;

/**
 * Created by Tien on 12/30/2017.
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
public class SortedArrayToBST108 {
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
     * Recursion
     * @param nums - sorted array
     * @return BST
     */
    TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return recursion(nums, 0, nums.length);
    }

    TreeNode recursion(int[] nums, int start, int end) {
        if(start >= end)
            return null;

        int middle = start + (end-start)/2; //avoid overflow, since start+end can cause it
        TreeNode node = new TreeNode(nums[middle]);
        node.left = recursion(nums, start, middle);
        node.right= recursion(nums, middle+1, end);

        return node;
    }
}

/**
 * Created by Tien on 8/16/2018.
 */
public class TreesAndGraphs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 4.1
     *
     * Time complexity: O(h) - h is the tree height
     * Space complexity: O(h)
     *
     * Implement a function to check if a tree is balanced. For the purposes of this question,
     * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        return maxDepth(root) - minDepth(root) <= 1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 4.3
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
     * @param array
     * @return
     */
    public TreeNode createMinimalBST(int[] array) {
        if(array.length == 0) return null;
        return helper(array, 0, array.length-1);
    }

    public TreeNode helper(int[] array, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode t = new TreeNode(array[mid]);
        t.left = helper(array, start, mid-1);
        t.right = helper(array, mid+1, end);
        return t;
    }
}

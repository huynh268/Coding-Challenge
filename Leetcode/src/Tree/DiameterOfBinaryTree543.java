package Tree;

/**
 * Created by Tien on 1/20/2018.
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

 Example:
 Given a binary tree
 1
 / \
 2   3
 / \
 4   5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree543 {
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
     * O(nlogn) Time complexity
     * O(n) Space
     *
     * Credit: daydayup for the explanation of time complexity
     * diameterOfBinaryTree is called on every node. In each call, it traverses all descendants of that node to get the depth.

        for root node, it is n => n + 1 - 2^0
        for all nodes on 2nd level, it is 2 * (n - 1) / 2 => n - 1 => n + 1 - 2^1
        for all nodes on 3rd level, it is 4 * (n - 3) / 4 => n - 3 => n + 1 - 2^2
        for all nodes on 4th level, it is 8 * (n - 7) / 8 => n - 7 => n + 1 - 2^3
        ...
        for all nodes on last level, it is n + 1 - 2^(h-1). h is max tree depth.
        Add them up, the result is (n+1) * h - (1 + 2 + 4 ... + 2^(h-1)). In worst case, the latter part is n (all nodes in the tree), so time complexity is O(n*logn).
     * @param root
     * @return
     */
    int diameterOfBinaryTree1(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth1(root.left) + maxDepth1(root.right),
                Math.max(diameterOfBinaryTree1(root.left), diameterOfBinaryTree1(root.right)));
    }

    int maxDepth1(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth1(root.left), maxDepth1(root.right));
    }


    /**
     * O(n) Time complexity - Each node is visited once
     * O(n) Space
     */
    int max = 0;
    int diameterOfBinaryTree2(TreeNode root) {
        if(root == null) return 0;
        maxDepth2(root);
        return max;
    }

    int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int leftDepth = maxDepth2(root.left);
        int rightDepth = maxDepth2(root.right);
        max = Math.max(max, leftDepth + rightDepth);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

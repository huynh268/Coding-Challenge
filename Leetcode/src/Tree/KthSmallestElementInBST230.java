package Tree;

import java.util.Stack;

/**
 * Created by Tien on 2/14/2018.
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementInBST230 {

    /**
     * Inorder Traversal - Iterative
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0) break;
            root = root.right;
        }
        return root.val;
    }

    /**
     * Inorder Traversal - Recursive
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    TreeNode ans = null;
    int count = 0;
    int kthSmallest2(TreeNode root, int k) {
        inorderTraversal(root, k);
        return ans.val;
    }

    void inorderTraversal(TreeNode root, int k) {
        if(root != null) {
            if(root.left != null) inorderTraversal(root.left, k);
            count++;
            if(count == k) ans = root;
            if(root.right != null) inorderTraversal(root.right, k);
        }
    }

    /**
     * Binary search - the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently
     * O(n) Time complexity - countNode takes O(n) and kthSmallest3 takes 0(lgn)
     *                      - if countLeft is added to the TreeNode structure, then the total nodes of left subtree is maintained every time new node is added
     *                      and the time complexity is O(lgn)
     * O(n) Space
     * @param root
     * @param k
     * @return
     */
    int kthSmallest3(TreeNode root, int k) {
        int countLeft = countNode(root.left);
        if(countLeft == k - 1) {
            return root.val;
        } else if(countLeft > k - 1) {
            return kthSmallest3(root.left, k);
        } else {
            return kthSmallest3(root.right, k - countLeft - 1);
        }
    }

    int countNode(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNode(root.left) + countNode(root.right);
    }
}

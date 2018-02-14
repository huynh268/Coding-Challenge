package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 2/13/2018.
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 Both the left and right subtrees must also be binary search trees.
 For example:
 Given BST [1,null,2,2],
  1
   \
   2
  /
 2
 return [2].

 Note: If a tree has more than one mode, you can return them in any order.

 Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class FindModeInBinarySearchTree501 {
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
     * O(n) Time complexity
     * O(n) Space
     * @param root
     * @return
     */
    int max1 = 0;
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int[] findMode1(TreeNode root) {
        inorderTraversal1(root);
        List<Integer> list = new ArrayList<>();
        for(int key : hashMap.keySet()) {
            if(hashMap.get(key) == max1) list.add(key);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    void inorderTraversal1(TreeNode root) {
        if(root != null) {
            if(root.left != null) inorderTraversal1(root.left);
            hashMap.put(root.val, hashMap.getOrDefault(root.val, 0) +  1);
            if(root.right != null) inorderTraversal1(root.right);
        }
    }

    /**
     * O(n) Time complexity
     * O(1) Space - Assume that the implicit stack space incurred due to recursion does not count!!!
     * @param root
     * @return
     */

    Integer previousNode = null;
    int max2 = 0;
    int count = 0;
    List<Integer> ans = new ArrayList<>();
    int[] findMode2(TreeNode root) {
        inorderTraversal2(root);
        return ans.stream().mapToInt(i->i).toArray();
    }

    void inorderTraversal2(TreeNode root) {
        if(root != null) {
            if(root.left != null) inorderTraversal2(root.left);
            if(previousNode != null && previousNode == root.val) {
                count++;
            } else {
                count = 1;
            }

            if(count > max2) {
                max2 = count;
                ans.clear();
                ans.add(root.val);
            } else if (count == max2){
                ans.add(root.val);
            }
            previousNode = root.val;
            if(root.right != null) inorderTraversal2(root.right);
        }
    }
}

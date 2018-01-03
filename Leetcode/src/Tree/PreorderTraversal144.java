package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 1/2/2018.
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
    1
     \
      2
     /
    3
 return [1,2,3].
 */
public class PreorderTraversal144 {
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
     * Iteratively - Using Stack
     * @param root
     * @return
     */
    List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return ans;
    }

    /**
     * Recursively
     * @param root
     * @return
     */
    List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            ans.add(root.val);
            ans.addAll(preorderTraversal2(root.left));
            ans.addAll(preorderTraversal2(root.right));
        }
        return ans;
    }
}

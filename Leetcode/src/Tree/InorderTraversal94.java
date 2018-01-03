package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 1/2/2018.
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

 For example:
 1 - Given binary tree [1,null,2,3],
    1
     \
      2
     /
    3
 return [1,3,2].

 2 - Given binary tree [1,4,2,3,5,7]
            1
          /   \
        4      2
      /  \    /
     3    5  7
 return [3,4,5,1,7,2]
 */
public class InorderTraversal94 {

    /**
     * Iteratively
     * @param root
     * @return
     */
    List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * Recursively
     * @param root
     * @return
     */
    List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root != null){
            if(root.left != null) ans.addAll(inorderTraversal2(root.left));
            ans.add(root.val);
            if(root.right != null) ans.addAll(inorderTraversal2(root.right));
        }
        return ans;
    }
}

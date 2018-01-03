package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tien on 1/2/2018.
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.

 For example:
 Given binary tree {1,#,2,3},
    1
     \
      2
     /
    3
 return [3,2,1].
 */
public class PostorderTraversal145 {

    /**
     * Iteratively
     * @param root
     * @return
     */
    List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root ==  null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            root = stack.pop();
            ans.add(0, root.val);
            if(root.left !=null) stack.push(root.left);
            if(root.right != null) stack.push(root.right);
        }
        return ans;
    }

    /**
     * Recursively
     * @param root
     * @return
     */
    List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root != null) {
            if(root.left != null) ans.addAll(postorderTraversal2(root.left));
            if(root.right != null) ans.addAll(postorderTraversal2(root.right));
            ans.add(root.val);
        }
        return ans;
    }
}

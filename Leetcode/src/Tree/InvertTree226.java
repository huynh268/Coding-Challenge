package Tree;

/**
 * Created by Tien on 1/2/2018.
 *
 * Invert a binary tree.
      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 to

      4
    /   \
   7     2
  / \   / \
 9   6 3   1
 */
public class InvertTree226 {

    TreeNode invertTree(TreeNode root) {
        if(root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null) invertTree(root.left);
            if(root.right != null) invertTree(root.right);
        }
        return root;
    }
}

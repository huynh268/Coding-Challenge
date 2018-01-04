package Tree;

import java.util.Stack;

/**
 * Created by Tien on 1/3/2018.
 */
public class BSTIterator173 {
    private Stack<TreeNode> stack;
    private TreeNode root;

    /**
     * Constructor
     * @param root - Generate new BST from TreeNode root
     */
    public BSTIterator173(TreeNode root) {
        this.root = root;
        this.stack = new Stack<TreeNode>();
        pushToStack(root);
    }

    /**
     * O(1) Time Complexity
     * @return Return whether there is a treenode in stack
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * O(1) Time Complexity - O(h) Space where h is the height of the tree
     * Since each node is visited twice (push to stack and pop out of stack)
     * @return The smallest value in BST
     */
    public int next() {
        TreeNode temp = stack.pop();
        pushToStack(temp.right);
        return temp.val;
    }

    /**
     * Push TreeNode root into stack - O(h) Time complexity - O(h) Space
     * @param root
     */
    private void pushToStack(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}

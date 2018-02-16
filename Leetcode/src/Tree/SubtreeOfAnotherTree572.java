package Tree;

/**
 * Created by Tien on 2/15/2018.
 *
 *
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

 Example 1:
 Given tree s:

     3
    / \
   4   5
  / \
 1   2
 Given tree t:
   4
  / \
 1   2
 Return true, because t has the same structure and node values with a subtree of s.
 Example 2:
 Given tree s:

       3
      / \
     4   5
    / \
   1   2
      /
     0
 Given tree t:
   4
  / \
 1   2
 Return false.

 */
public class SubtreeOfAnotherTree572 {

    /**
     * O(m*n) Time complexity
     * O(n) Space
     * @param s
     * @param t
     * @return
     */
    boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isIdentical(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 ==  null) return false;
        return t1.val == t2.val && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }
}

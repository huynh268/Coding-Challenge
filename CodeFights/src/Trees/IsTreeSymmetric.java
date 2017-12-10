package Trees;

/**
 * Created by Tien on 11/16/2017.
 * Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
 *      1
       / \
      2   2
     / \ / \
    3  4 4  3
    the output should be isTreeSymmetric(t) = true.

        1
       / \
      2   2
      \   \
      3    3
    the output should be isTreeSymmetric(t) = false.
 */


public class IsTreeSymmetric {

    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }


    //Recursive
    public static boolean isTreeSymmetric(Tree<Integer> t) {
        if(t == null)
            return true;
        return check(t.left, t.right);
    }

    private static boolean check(Tree<Integer> l, Tree<Integer> r) {
        if(l == null && r == null)
            return true;

        if(l == null || r == null)
            return false;

        return l.value.equals(r.value)
                && check(l.left, r.right)
                && check(l.right, r.left);
    }
}

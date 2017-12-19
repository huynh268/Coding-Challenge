package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 12/10/2017.
 */
public class IsSubtree {

    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }

    boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
        if(t1 == null && t2 == null)
            return true;

        if(t1 == null)
            return false;

        if(t2 == null)
            return true;

        if(isIdentical(t1,t2))
            return true;

        return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
    }

    boolean isIdentical(Tree<Integer> t1, Tree<Integer> t2) {
        if(t1 == null && t2 == null)
            return true;

        if(t1 == null || t2 == null)
            return false;

        return t1.value.equals(t2.value) && isIdentical(t1.left, t2.left)
                && isIdentical(t1.right, t2.right);
    }

}

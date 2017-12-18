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

    int[] traverseTree(Tree<Integer> t) {
        if(t == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.add(t);

        while(!queue.isEmpty()) {
            t = queue.poll();
            list.add(t.value);
            if(t.left !=  null) queue.add(t.left);
            if(t.right != null) queue.add(t.right);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

}

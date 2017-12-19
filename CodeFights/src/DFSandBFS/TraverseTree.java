package DFSandBFS;

import Trees.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 12/18/2017.
 *
 * Given a binary tree of integers t, return its node values in the following format:

 The first element should be the value of the tree root;
 The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost to the rightmost one;
 The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) ordered in the same way;
 Etc.
 Example

 For

 t = {
 "value": 1,
 "left": {
 "value": 2,
 "left": null,
 "right": {
 "value": 3,
 "left": null,
 "right": null
 }
 },
 "right": {
 "value": 4,
 "left": {
 "value": 5,
 "left": null,
 "right": null
 },
 "right": null
 }
 }
 the output should be
 traverseTree(t) = [1, 2, 4, 3, 5].

 This t looks like this:

     1
   /   \
  2     4
  \    /
   3  5
 */
public class TraverseTree {

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

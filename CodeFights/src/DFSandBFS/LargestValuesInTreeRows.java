package DFSandBFS;

import Trees.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tien on 12/18/2017.
 *
 * You have a binary tree t. Your task is to find the largest value in each row of this tree.
 * In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root,
 * a row with depth 1 is composed of the root's children, etc.

 Return an array in which the first element is the largest value in the row with depth 0,
 the second element is the largest value in the row with depth 1,
 the third element is the largest element in the row with depth 2, etc.

 Example

 For

 t = {
 "value": -1,
    "left": {
        "value": 5,
        "left": null,
        "right": null
        },
    "right": {
        "value": 7,
        "left": null,
        "right": {
            "value": 1,
            "left": null,
            "right": null
            }
        }
    }
 the output should be largestValuesInTreeRows(t) = [-1, 7, 1].

 The tree in the example looks like this:

    -1
    / \
   5   7
    \
     1
 In the row with depth 0, there is only one vertex - the root with value -1;
 In the row with depth 1, there are two vertices with values 5 and 7, so the largest value here is 7;
 In the row with depth 2, there is only one vertex with value 1.
 */
public class LargestValuesInTreeRows {

    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }

    //BFS
    int[] largestValuesInTreeRows(Tree<Integer> t) {
        if(t == null)
            return new int[0];

        List<Integer> list = new ArrayList<>();
        Queue<Tree<Integer>> queue = new LinkedList<>();

        queue.add(t);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                Tree<Integer> tempNode = queue.poll();
                if(tempNode.value > max) max = tempNode.value;
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
            list.add(max);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}

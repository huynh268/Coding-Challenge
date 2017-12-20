package DFSandBFS;

import Trees.Tree;

import java.util.Stack;

/**
 * Created by Tien on 12/18/2017.
 *
 * We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9),
 * and each path from root to leaf encodes a non-negative integer.

 Given a binary tree t, find the sum of all the numbers encoded in it.

 Example

 For
 t = {
        "value": 1,
        "left": {
                "value": 0,
                "left": {
                        "value": 3,
                        "left": null,
                        "right": null
                },
                "right": {
                        "value": 1,
                        "left": null,
                        "right": null
                }
        },
        "right": {
                "value": 4,
                "left": null,
                "right": null
        }
 }
 the output should be
 digitTreeSum(t) = 218.
 There are 3 numbers encoded in this tree:

 Path 1->0->3 encodes 103
 Path 1->0->1 encodes 101
 Path 1->4 encodes 14
 and their sum is 103 + 101 + 14 = 218.


 t = {
        "value": 0,
        "left": {
                "value": 9,
                "left": null,
                "right": null
                },
        "right": {
                "value": 9,
                "left": {
                        "value": 1,
                        "left": null,
                        "right": null
                        },
                "right": {
                        "value": 3,
                        "left": null,
                        "right": null
                        }
                }
    }
 the output should be
 digitTreeSum(t) = 193.
 Because 09 + 091 + 093 = 193

 */
public class DigitTreeSum {

    //DFS - Iteratively
    class Pair{
        Tree<Integer> tree;
        long sum;

        Pair(Tree<Integer> tree, long sum) {
            this.tree = tree;
            this.sum = sum;
        }
    }

    long digitTreeSum1(Tree<Integer> t) {
        if(t == null) return 0;

        long sum = 0;
        Stack<Pair> stack = new Stack<>();

        stack.push(new Pair(t, 0));
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            Tree<Integer> tmp = p.tree;
            long currentSum = p.sum;

            currentSum = currentSum*10 + tmp.value;

            if(tmp.left == null && tmp.right == null)
                sum += currentSum;

            if(tmp.left != null)
                stack.push(new Pair(tmp.left, currentSum));

            if(tmp.right != null)
                stack.push(new Pair(tmp.right, currentSum));
        }
        return sum;
    }

    //DFS - Recursively
    long digitTreeSum2(Tree<Integer> t) {
        return helper(t, 0);
    }

    long helper(Tree<Integer> t, long sum) {
        if(t == null)
            return 0;

        sum = sum*10 + t.value;

        if(t.left == null && t.right == null)
            return sum;

        else
            return helper(t.left, sum) + helper(t.right, sum);
    }
}

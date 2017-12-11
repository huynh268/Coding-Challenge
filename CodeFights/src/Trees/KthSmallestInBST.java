package Trees;

/**
 * Created by Tien on 12/10/2017.
 *
 * A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and the right subtrees must also be binary search trees.
 Given a binary search tree t, find the kth smallest element in it.

 Note that kth smallest element means kth element in increasing order. See examples for better understanding.

 Example

 For

 t = {
 "value": 3,
 "left": {
 "value": 1,
 "left": null,
 "right": null
 },
 "right": {
 "value": 5,
 "left": {
 "value": 4,
 "left": null,
 "right": null
 },
 "right": {
 "value": 6,
 "left": null,
 "right": null
 }
 }
 }
 and k = 4, the output should be
 kthSmallestInBST(t, k) = 5.

 Here is what t looks like:

     3
   /   \
  1     5
 / \
 4   6
 The values of t are [1, 3, 4, 5, 6], and the 4th smallest is 5.
 */

public class KthSmallestInBST {

    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }
}


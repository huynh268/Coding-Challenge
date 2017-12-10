package Trees;

/**
 * Created by Tien on 12/9/2017.
 *
 * Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values equals s.

 Example

 For

 t = {
 "value": 4,
 "left": {
 "value": 1,
 "left": {
 "value": -2,
 "left": null,
 "right": {
 "value": 3,
 "left": null,
 "right": null
 }
 },
 "right": null
 },
 "right": {
 "value": 3,
 "left": {
 "value": 1,
 "left": null,
 "right": null
 },
 "right": {
 "value": 2,
 "left": {
 "value": -2,
 "left": null,
 "right": null
 },
 "right": {
 "value": -3,
 "left": null,
 "right": null
 }
 }
 }
 }
 and
 s = 7,
 the output should be hasPathWithGivenSum(t, s) = true.
 */

public class HasPathWithGivenSum {

    // Definition for binary tree:
    // class Tree<T> {
    //   Tree(T x) {
    //     value = x;
    //   }
    //   T value;
    //   Tree<T> left;
    //   Tree<T> right;
    // }

    boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
        if(t == null) {
            return s == 0? true:false;
        }
        else if(t.value == s &&  t.left == null && t.right == null) return true;
        else if(t.value == s && t.left == null && t.right != null)
            return hasPathWithGivenSum(t.right, s-t.value);
        else if(t.value == s && t.left != null && t.right == null)
            return hasPathWithGivenSum(t.left, s-t.value);
        else{
            System.out.println(t.value);
            return hasPathWithGivenSum(t.left, s - t.value)||hasPathWithGivenSum(t.right, s-t.value);
        }
    }
}

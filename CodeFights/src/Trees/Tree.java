package Trees;

/**
 * Created by Tien on 12/9/2017.
 */
public class Tree<T> {
    Tree(T x) {
        value = x;
    }
    T value;
    Tree<T> left;
    Tree<T> right;
}

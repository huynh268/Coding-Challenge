package Trees;

/**
 * Created by Tien on 12/9/2017.
 */
public class Tree<T> {
    Tree(T x) {
        value = x;
    }
    public T value;
    public Tree<T> left;
    public Tree<T> right;
}

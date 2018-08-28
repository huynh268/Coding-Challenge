package Tree;

import java.util.List;

/**
 * Created by Tien on 8/27/2018.
 *
 *
 *
 * Given a n-ary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 Note:
 The depth of the tree is at most 1000.
 The total number of nodes is at most 5000.
 */
public class MaximumDepthOfNAryTree559 {


    class Node {
         public int val;
         public List<Node> children;

         public Node(int _val,List<Node> _children) {
              val = _val;
              children = _children;
         }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param root
     * @return
     */
    public int maxDepth1(Node root) {
        if(root == null) return 0;

        int max = 1;
        for(int i = 0; i < root.children.size(); i++) {
            max = Math.max(max, maxDepth1(root.children.get(i)) + 1);
        }

        return max;
    }



    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null) return 0;
        dfs(root, 1);
        return max;
    }

    int max = 1;
    private void dfs(Node root, int depth) {
        if(root != null) {
            for(int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), depth + 1);
                max = Math.max(max, depth + 1);
            }
        }
    }

}

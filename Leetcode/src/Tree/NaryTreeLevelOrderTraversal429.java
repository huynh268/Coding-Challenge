package Tree;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * Note:

 The depth of the tree is at most 1000.
 The total number of nodes is at most 5000.
 */

public class NaryTreeLevelOrderTraversal429 {
    /*
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    */

    /**
     * BFS
     *
     * Time complexity: O(N) visit each node twice(add and remove from queue)
     * Space compleixty: O(N)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while(size > 0) {
                root = queue.poll();
                level.add(root.val);
                for(Node n : root.children) {
                    if(n != null) queue.offer(n);
                }
                size--;
            }
            ans.add(level);
        }

        return ans;
    }
}

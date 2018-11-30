package Tree;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * Note:

 Recursive solution is trivial, could you do it iteratively?
 */

public class NaryTreePostorderTraversal590 {
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
     * DFS
     *
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            ans.add(0, root.val);
            for(Node n : root.children) {
                if(n != null) stack.push(n);
            }
        }
        return ans;
    }
}

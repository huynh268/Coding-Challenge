package Tree;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 */

public class NaryTreePreorderTraversal589 {
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
     * Recursive
     *
     * Time complexity: O(N) visit each node once
     * Space complexity: O(N)
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, ans);
        return ans;
    }

    private void dfs(Node root, List<Integer> ans) {
        if(root != null) {
            ans.add(root);
            for(Node n : root.children) {
                if(n != null) dfs(n);
            }
        }
    }

    /**
     * Iterative
     *
     * Time complexity: O(N) visit each node twice(add and remove from stack)
     * Space Complexity: O(N)
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            Collections.reverse(root.children);
            for(Node n : root.children) {
                if(n != null) stack.push(n);
            }
        }

        return ans;
    }
}

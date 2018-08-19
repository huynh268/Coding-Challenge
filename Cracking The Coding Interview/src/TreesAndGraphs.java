import com.sun.tools.jdeps.Graph;

import java.util.*;


/**
 * Created by Tien on 8/16/2018.
 */
public class TreesAndGraphs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 4.1
     *
     * Time complexity: O(h) - h is the tree height
     * Space complexity: O(h)
     *
     * Implement a function to check if a tree is balanced. For the purposes of this question,
     * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one.
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root){
        return maxDepth(root) - minDepth(root) <= 1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }



    /**
     * 4.2
     *
     * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
     */
    public class DirectedGraphNode {
        int label;
        List<DirectedGraphNode> neighbors;
        State state;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public class DirectedGraph {
        List<DirectedGraphNode> nodes;

        DirectedGraph(List<DirectedGraphNode> nodes) {
            this.nodes = nodes;
        }
    }

    public enum State {
        unvisited, visiting, visited;
    }

    public boolean search(DirectedGraph graph, DirectedGraphNode start, DirectedGraphNode end) {
        if(graph == null || graph.nodes == null) return false;

        for(DirectedGraphNode node : graph.nodes) {
            node.state = State.unvisited;
        }

        Stack<DirectedGraphNode> stack = new Stack<>(); //DFS
        stack.push(start);
        start.state = State.visiting;
        DirectedGraphNode currentNode;

        while(!stack.isEmpty()) {
            currentNode = stack.pop();
            currentNode.state = State.visited;
            for(DirectedGraphNode node : currentNode.neighbors) {
                if(node.state == State.unvisited) {
                    if(node == end) return true;
                    node.state = State.visiting;
                    stack.push(node);
                }
            }
        }

        return false;
    }

    /**
     * 4.3
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
     * @param array
     * @return
     */
    public TreeNode createMinimalBST(int[] array) {
        if(array.length == 0) return null;
        return helper(array, 0, array.length-1);
    }

    public TreeNode helper(int[] array, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode t = new TreeNode(array[mid]);
        t.left = helper(array, start, mid-1);
        t.right = helper(array, mid+1, end);
        return t;
    }


    /**
     * 4.4
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
     * (eg, if you have a tree with depth D, you’ll have D linked lists).
     * @param root
     * @return
     */
    public List<List<TreeNode>> findLevelLinkList(TreeNode root) {
        List<List<TreeNode>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<TreeNode> list = new ArrayList<>();
            while(size > 0) {
                root = q.poll();
                list.add(root);
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
                size--;
            }
            ans.add(list);
        }
        return ans;
    }

    /**
     * 4.5
     *
     * Time complexity: O(h)
     * Space complexity: O(1)
     *
     * Write an algorithm to find the ‘next’ node (e.g., in-order successor) of a given node in a binary search tree
     * where each node has a link to its parent.
     */
    public class TreeNodeP {
        TreeNodeP left, right, parent;
        int val;

        public TreeNodeP(int val) {
            this.val = val;
        }
    }

    public TreeNodeP inorderSucc(TreeNodeP e) {
        if(e != null) {
            TreeNodeP parent;
            if(e.parent == null || e.right != null) {
                parent = leftMost(e);
            } else {
                while((parent = e.parent) != null) {
                    if(parent.left == e) break;
                    e = parent;
                }
            }

            return parent;
        }
        return null;
    }

    public TreeNodeP leftMost(TreeNodeP root) {
        if(root == null) return null;
        while(root.left != null) root = root.left;
        return root;
    }

    /**
     * 4.6
     *
     * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
     * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;

        return root;
    }

    /**
     * 4.7
     *
     * Time complexity: worst case O(m*n) when tree is skewed
     * Space complexity: O(n) where n is the #node of bigger tree
     *
     * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
     * Create an algorithm to decide if T2 is a subtree of T1.
     * @param r1
     * @param r2
     * @return
     */
    public boolean subTree(TreeNode r1, TreeNode r2) {
        if(r1 == null) return false;
        return isIdentical(r1, r2) || isIdentical(r1.left, r2) || isIdentical(r1.right, r2);
    }

    public boolean isIdentical(TreeNode r1, TreeNode r2) {
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;
        return r1 == r2 && isIdentical(r1.left, r2.left) && isIdentical(r1.right, r2.right);
    }

    /**
     * 4.8
     *
     * You are given a binary tree in which each node contains a value. Design an algorithm to print all
     * paths which sum up to that value. Note that it can be any path in the tree - it does not have to start at the root.
     * @param root
     * @param sum
     * @return
     */
    public List<List<TreeNode>> pathSum(TreeNode root, int sum) {
        List<List<TreeNode>> result = new ArrayList<>();
        helper(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void helper(TreeNode root, int sum, List<TreeNode> list, List<List<TreeNode>> result) {
        if(root == null) return;

        list.add(root);
        if(root.val == sum) result.add(list);

        //Paths starts from previous nodes
        //Create copies of list for left and right path
        //then continue to search for a path that sums up to sum
        helper(root.left, sum - root.val, new ArrayList<>(list), result);
        helper(root.right, sum - root.val, new ArrayList<>(list), result);

        //New paths starts at current node
        helper(root.left, sum, new ArrayList<>(), result);
        helper(root.right, sum, new ArrayList<>(), result);
    }
}

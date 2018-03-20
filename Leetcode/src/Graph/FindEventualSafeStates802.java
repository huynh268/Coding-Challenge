package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 3/17/2018.
 *
 *
 *
 * n a directed graph, we start at some node and every turn, walk along a directed edge of the graph.
 * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

 Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
 More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

 Which nodes are eventually safe?  Return them as an array in sorted order.

 The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.
 The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

 Example:
 Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 Output: [2,4,5,6]
 Here is a diagram of the above graph.

 Note:

 graph will have length at most 10000.
 The number of edges in the graph will not exceed 32000.
 Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class FindEventualSafeStates802 {

    /**
     * DFS
     * O(N + E) Time complexity
     * O(N) Space
     *
     * color 0 = not visited yet, 1 = safe, 2 = unsafe
     * Visit each node and label it with 2 then check all of its connected nodes, if all of its connected nodes are safe then it is safe.
     *
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            if(dfs(graph, color, i)) ans.add(i);
        }

        return ans;
    }

    private boolean dfs(int[][] graph, int[] color, int node) {

        //If node was visited, then just check if it is safe
        if(color[node] != 0) return color[node] == 1;

        //Otherwise, label it as unsafe and then check all of its edges
        color[node] = 2;
        for(int nextNode : graph[node]) {
            if(!dfs(graph, color, nextNode)) return false;
        }

        //If node connects to all safe nodes, then it is a safe node, so relabel it as safe = 1
        color[node] = 1;
        return true;
    }
}

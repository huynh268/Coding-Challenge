package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 3/11/2018.
 *
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

 The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

 Example:
 Input: [[1,2], [3], [3], []]
 Output: [[0,1,3],[0,2,3]]
 Explanation: The graph looks like this:
 0--->1
 |    |
 v    v
 2--->3
 There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 Note:

 The number of nodes in the graph will be in the range [2, 15].
 You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
public class AllPathsFromSourceToTarget797 {

    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        if(graph == null || graph.length == 0) return ans;

        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, ans);

        return ans;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> ans) {
        if(node == graph.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i : graph[node]) {
            path.add(i);
            dfs(graph, i, path, ans);
            path.remove(path.size()-1);
        }
    }
}

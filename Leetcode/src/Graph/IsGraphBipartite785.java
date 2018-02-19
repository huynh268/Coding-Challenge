package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 2/18/2018.
 *
 * https://leetcode.com/problems/is-graph-bipartite/discuss/115561/Java-BFS-solution-based-on-2-color-problem
 *
 * Given a graph, return true if and only if it is bipartite.

 Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

 The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.
 There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

 Example 1:
 Input: [[1,3], [0,2], [1,3], [0,2]]
 Output: true
 Explanation:
 The graph looks like this:
 0----1
 |    |
 |    |
 3----2
 We can divide the vertices into two groups: {0, 2} and {1, 3}.

 Example 2:
 Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 Output: false
 Explanation:
 The graph looks like this:
 0----1
 | \  |
 |  \ |
 3----2
 We cannot find a way to divide the set of nodes into two independent ubsets.


 Note:
 graph will have length in range [1, 100].
 graph[i] will contain integers in range [0, graph.length - 1].
 graph[i] will not contain i or duplicate values.
 */
public class IsGraphBipartite785 {

    /**
     * Graph Coloring
     * DFS - Recursive
     * O(E + N) Time complexity
     * O(N) Space
     * @param graph
     * @return
     */
    boolean isBipartite1(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        //Fill colors array with -1
        //-1 = not colored yet
        // 0 = white
        // 1 = Black
        for(int i = 0; i < n; i++)
            colors[i] = -1;

        //Since the graph can be  a disconnected graph, check all vertices
        for(int i = 0; i < n; i++) {
            if(colors[i] == -1 && !coloring(graph, colors, 0, i))
                return false;
        }
        return true;
    }

    /**
     * DFS
     * @param graph - the given graph
     * @param colors - the array is used to check if 2 connected vertices are colored differently
     * @param color - the color used to paint the vertex
     * @param vertex - the vertex needed to colored
     * @return
     */
    boolean coloring(int[][] graph, int[] colors, int color, int vertex) {
        if(color != -1) {
            return colors[color] == color;
        }

        colors[vertex] = color;
        for(int neighbor : graph[vertex]) {
            if(!coloring(graph, colors, 1 - color, neighbor))
                return false;
        }
        return true;
    }

    /****************************************************************************************************************/

    /**
     * Graph Coloring
     * DSF - Iterative
     * O(E + N) Time complexity
     * O(N) Space
     * @param graph
     * @return
     */
    boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int vertex = 0; vertex < n; vertex++) {
            if(colors[vertex] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(vertex);
                colors[vertex] = 0;

                while(!stack.isEmpty()) {
                    int v = stack.pop();
                    for(int neighbor : graph[v]) {
                        if(colors[neighbor] == -1) {
                            colors[neighbor] = 1 - colors[v];
                            stack.push(neighbor);
                        } else if(colors[neighbor] == colors[v]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /****************************************************************************************************************/

    /**
     * Graph Coloring
     * BFS - Iterative
     * O(E+N) Time complexity
     * O(N) Space
     * @param graph
     * @return
     */
    boolean isBipartite3(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int vertex = 0; vertex < n; vertex++) {
            if(colors[vertex] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(vertex);
                colors[vertex] = 0;

                while(!queue.isEmpty()) {
                    int v = queue.remove();
                    for(int neighbor : graph[v]) {
                        if(colors[neighbor] == -1) {
                            queue.add(neighbor);
                            colors[neighbor] = 1 - colors[v];
                        } else if (colors[neighbor] == colors[v]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

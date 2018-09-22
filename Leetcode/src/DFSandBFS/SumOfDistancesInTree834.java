package DFSandBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 9/21/2018.
 *
 * https://leetcode.com/problems/sum-of-distances-in-tree/description/
 *
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 The ith edge connects nodes edges[i][0] and edges[i][1] together.
 Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.

 Example 1:
 Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 Output: [8,12,6,10,10,10]
 Explanation:
 Here is a diagram of the given tree:
    0
   / \
  1   2
     /|\
    3 4 5
 We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.

 Note: 1 <= N <= 10000


 */
public class SumOfDistancesInTree834 {
    class Graph {
        private HashMap<Integer, List<Integer>> graph;

        public Graph() {
            this.graph = new HashMap<>();
        }

        public void addEdge(int[] edge) {
            if(!graph.containsKey(edge[0])) graph.put(edge[0], new ArrayList<Integer>());
            if(!graph.containsKey(edge[1])) graph.put(edge[1], new ArrayList<Integer>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        public List<Integer> getListNodes(int n) {
            if(!graph.containsKey(n)) return null;
            return graph.get(n);
        }
    }
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        
    }
}

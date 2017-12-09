import java.util.ArrayList;

/**
 * Created by Tien on 12/7/2017.
 *
 * Create Adjacency List to represent the undirected graph
 */
public class AdjacencyList {

    static class Graph {
        int V; //Vertex
        ArrayList<Integer>[] adjacencyArray;

        //Constructor
        Graph(int V) {
            this.V = V;
            adjacencyArray = new ArrayList[V];

            for(int i = 0; i < V; i++) {
                adjacencyArray[i] = new ArrayList<>();
            }
        }
    }

    /**
     *
     * @param graph - graph that has a pair of vertices that will be connected
     * @param pair - pair of vertices that have the connection
     */
    static void addEdge(Graph graph, int[] pair) {
        //If pair[0] > pair[1], then swap them
        if(pair[0] > pair[1]) {
            int temp = pair[0];
            pair[0] = pair[1];
            pair[1] = temp;
        }
        
        if(pair[0] != pair[1] && !graph.adjacencyArray[pair[0]].contains(pair[1])) {
            graph.adjacencyArray[pair[0]].add(pair[1]);
            graph.adjacencyArray[pair[1]].add(pair[0]);
        }
    }

    /**
     *
     * @param graph - graph will be printed out
     */
    static void printGraph(Graph graph) {
        for(int v = 0; v < graph.V; v++) {
            System.out.print("Adjacency list of vertex "+ v + " : head");
            for(Integer i : graph.adjacencyArray[v]) {
                System.out.print(" -> "+ i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        addEdge(graph,new int[]{0,1});
        addEdge(graph,new int[]{0,2});
        addEdge(graph,new int[]{0,4});
        addEdge(graph,new int[]{1,2});
        addEdge(graph,new int[]{1,3});
        addEdge(graph,new int[]{4,1});
        addEdge(graph,new int[]{2,3});
        addEdge(graph,new int[]{2,4});
        addEdge(graph,new int[]{3,4});
        addEdge(graph,new int[]{3,4});
        printGraph(graph);
    }
}

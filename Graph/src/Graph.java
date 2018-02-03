/**
 * Created by Tien on 2/2/2018.
 */

import java.util.*;

/**
 * Graph Class
 */

public class Graph<T> {
    private Map<T, HashSet<T>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    //Add new vertex into Graph
    public void addVertex(T vertex) {
        if(!hasVertex(vertex)) adjacencyList.put(vertex, new HashSet<>());
    }

    // Check if vertex is in Graph. Return true if vertex is in Graph
    public boolean hasVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Add edge between vertex v1 and v2
    // If v1 or v2 is not in Graph yet, add them into Graph and add the edge between them
    public void addEdge(T v1, T v2) {
        // Inputs are only one vertex(addEdge(v1, v1)), doesn't generate the edge
        // Duplicate calls 'addEdge' don't generate the same edge
        if(!v1.equals(v2) && !hasEdge(v1, v2)){
            if(!hasVertex(v1)) addVertex(v1);
            if(!hasVertex(v2)) addVertex(v2);
            HashSet<T> hashSet1 = adjacencyList.get(v1);
            hashSet1.add(v2);
            HashSet<T> hashSet2 = adjacencyList.get(v2);
            hashSet2.add(v1);
            adjacencyList.put(v1, hashSet1);
            adjacencyList.put(v2, hashSet1);
        }
    }

    // Check if there is an edge between v1 and v2. Return true if they are connected
    public boolean hasEdge(T v1, T v2) {
        if(!adjacencyList.containsKey(v1) || !adjacencyList.containsKey(v2)) return false;
        return adjacencyList.get(v1).contains(v2);
    }

    // Remove the edge between v1 and v2
    public boolean removeEdge(T v1, T v2) {
        if(!v1.equals(v2)) {
            HashSet<T> hashSet1 = adjacencyList.get(v1);
            hashSet1.remove(v2);
            HashSet<T> hashSet2 = adjacencyList.get(v2);
            hashSet2.remove(v1);
            adjacencyList.put(v1, hashSet1);
            adjacencyList.put(v2, hashSet2);
            return true;
        }
        return false;
    }

    // Remove the vertex and all of its edges with other vertices
    public boolean removeVertex(T vertex) {
        if(!hasVertex(vertex)) return false;
        else{
            Iterator itr = adjacencyList.get(vertex).iterator();
            while(itr.hasNext()) {
                T neighbor = (T)itr.next();
                HashSet<T> hashSet = adjacencyList.get(neighbor);
                hashSet.remove(vertex);
                adjacencyList.put(neighbor, hashSet);
            }
            adjacencyList.remove(vertex);
            return true;
        }
    }

    // Traverse Graph by using Depth First Search
    public List<T> DFS(T startVertex) {
        List<T> ans = new ArrayList<>();
        if(!hasVertex(startVertex) || adjacencyList.get(startVertex).size() == 0) return ans;

        HashMap<T, Integer> visited = new HashMap<>();
        dfsRecursive(startVertex, visited, ans);
        return ans;
    }

    // Recursive DFS
    private void dfsRecursive(T startVertex, HashMap<T, Integer> visited, List<T> ans) {
        ans.add(startVertex);
        visited.put(startVertex, 1);
        Iterator itr = adjacencyList.get(startVertex).iterator();
        while(itr.hasNext()) {
            T vertex = (T)itr.next();
            if(visited.get(vertex) == 0)
                dfsRecursive(vertex, visited, ans);
        }
    }

    public List<T> BFS(T startVertex) {
        List<T> ans = new ArrayList<>();
        if(!hasVertex(startVertex) || adjacencyList.get(startVertex).size() == 0) return ans;

        HashMap<T, Integer> visited = new HashMap<>();
        Queue<T> queue = new LinkedList<T>();

        visited.put(startVertex, 1);
        queue.add(startVertex);

        while(queue.size() != 0) {
            startVertex = queue.poll();
            ans.add(startVertex);
            Iterator itr = adjacencyList.get(startVertex).iterator();
            while(itr.hasNext()) {
                T vertex = (T)itr.next();
                if(visited.get(vertex) == 0)
                    queue.add(vertex);
            }
        }
        return ans;
    }
}
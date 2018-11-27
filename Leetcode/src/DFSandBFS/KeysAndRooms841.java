package DFSandBFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

 Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

 Initially, all the rooms start locked (except for room 0).

 You can walk back and forth between rooms freely.

 Return true if and only if you can enter every room.

 Example 1:
 Input: [[1],[2],[3],[]]
 Output: true
 Explanation:
 We start in room 0, and pick up key 1.
 We then go to room 1, and pick up key 2.
 We then go to room 2, and pick up key 3.
 We then go to room 3.  Since we were able to go to every room, we return true.

 Example 2:
 Input: [[1,3],[3,0,1],[2],[0]]
 Output: false
 Explanation: We can't enter the room with number 2.

 Note:
 1 <= rooms.length <= 1000
 0 <= rooms[i].length <= 1000
 The number of keys in all rooms combined is at most 3000.
 */

public class KeysAndRooms841 {

    /**
     * DFS - Stack
     * O(V + E) Time complexity - V is the total vertices, and E is the total edges
     * O(V) Space
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {

        //Check if vertex is visited
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true; //Always start with 0

        Stack<Integer> stack = new Stack<>();
        stack.push(0); //Start with 0

        while(!stack.isEmpty()) {
            int vertex = stack.pop();
            for(int neighbor : rooms.get(vertex)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        for(boolean vertex : visited) { //Check if every vertex is visited
            if(vertex) return false;
        }

        return true;
    }

    /**
     * BFS
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {

        //Check if vertex is visited
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true; //Always start with 0

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); //Start with 0

        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(int neighbor : rooms.get(vertex)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        for(boolean vertex : visited) { //Check if every vertex is visited
            if(vertex) return false;
        }

        return true;
    }

    /**
     * DFS - Iterative
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        dfs(rooms, visited, 0);

        for(boolean v : visited) {
            if(!v) return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int v) {
        for(int i : rooms.get(v)) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(rooms, visited, i);
            }
        }
    }
}

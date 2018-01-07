package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 1/6/2018.
 *
 * https://leetcode.com/problems/max-area-of-island/description/
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

 Example 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 Example 2:
 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.
 */
public class MaxAreaofIsland695 {

    /**
     * DFS - recursion
     * Since each node is visited once, and there are m*n nodes, Time complexity is O(mn) where m is #rows and n is #cols
     * O(mn) Space - visited array
     * @param grid
     * @return
     */
    int maxAreaOfIsland1(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, areaOfIsland(grid, visited, i, j));
            }
        }
        return max;
    }

    int areaOfIsland(int[][] grid, boolean[][] visited, int row, int col) {
        //if the square(r,c) is out of bound or it is visited or its value is 0, then skip it and return 0
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }
        visited[row][col] = true;
        return 1 +  areaOfIsland(grid, visited, row+1, col)+
                    areaOfIsland(grid, visited, row-1, col)+
                    areaOfIsland(grid, visited, row, col+1)+
                    areaOfIsland(grid, visited, row, col-1);
    }

    /**
     * DFS - Stack
     * @param grid
     * @return
     */
    int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = 0;
                if(!visited[i][j] && grid[i][j] == 1) {
                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i,j});
                    visited[i][j] = true;

                    while(!stack.isEmpty()) {
                        int[] node = stack.pop();
                        area++;
                        for(int[] move :  moves) {
                            int nextRow = node[0] + move[0];
                            int nextCol = node[1] + move[1];
                            if(nextRow < 0 || nextRow >= grid.length ||
                                    nextCol < 0 || nextCol >= grid[0].length ||
                                    visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0) {
                                continue;
                            }

                            visited[nextRow][nextCol] = true;
                            stack.push(new int[]{nextRow, nextCol});
                        }
                    }
                }

                max = Math.max(max, area);
            }
        }

        return max;
    }

    /**
     * DFS and BFS using helper functions
     * @param grid
     * @return
     */
    int maxAreaOfIsland3(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, visited, moves, i, j));
                //max = Math.max(max, bfs(grid, visited, moves, i, j));
            }
        }
        return max;
    }

    /**
     * DFS helper function - Stack
     * @param grid - Original grid
     * @param visited - Used to check if the node is visited
     * @param moves - Array to store the vertical and horizontal moves
     * @param row
     * @param col
     * @return
     */
    int dfs(int[][] grid, boolean[][] visited, int[][] moves, int row, int col) {
        int area = 0;

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
                visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});
        visited[row][col] = true;

        while(!stack.isEmpty()) {
            area++;
            int[] node = stack.pop();
            for(int[] move : moves) {
                int nextRow = node[0] + move[0];
                int nextCol = node[1] + move[1];

                if(nextRow < 0 || nextRow >= grid.length ||
                        nextCol < 0 || nextCol >= grid[0].length ||
                        visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0)
                    continue;

                visited[nextRow][nextCol] = true;
                stack.push(new int[]{nextRow, nextCol});
            }
        }

        return area;
    }

    /**
     * BFS helper function - Queue
     * @param grid
     * @param visited
     * @param moves
     * @param row
     * @param col
     * @return
     */
    int bfs(int[][] grid, boolean[][] visited, int[][] moves, int row, int col) {
        int area = 0;

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
                visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            area++;
            int[] node = queue.remove();
            for(int[] move : moves) {
                int nextRow = node[0] + move[0];
                int nextCol = node[1] + move[1];

                if(nextRow < 0 || nextRow >= grid.length ||
                        nextCol < 0 || nextCol >= grid[0].length ||
                        visited[nextRow][nextCol] || grid[nextRow][nextCol] == 0)
                    continue;

                visited[nextRow][nextCol] = true;
                queue.add(new int[]{nextRow, nextCol});
            }
        }

        return area;
    }
}

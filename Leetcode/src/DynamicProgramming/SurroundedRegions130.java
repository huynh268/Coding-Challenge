package DynamicProgramming;

/**
 * Created by Tien on 9/19/2018.
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:
 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X

 Explanation:
 Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions130 {

    /**
     * Recursion DFS
     *
     * Time complexity: O(n*m)
     * Space complexity: O(1)
     * 
     * @param board
     */
    public void solve(char[][] board) {
        int n = board.length;
        if(n <= 2) return;
        int m = board[0].length;

        for(int i = 0; i < n; i++) {
            dfs(board, i, 0);
        }
        for(int i = 0; i < m; i++) {
            dfs(board, 0, i);
        }
        for(int i = n-1; i >= 0; i--) {
            dfs(board, i, m-1);
        }
        for(int i = m-1; i >= 0; i--) {
            dfs(board, n-1, i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'X') continue;
                else if(board[i][j] == '*') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length) return;

        if(board[i][j] != 'O') return;

        board[i][j] = '*';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}

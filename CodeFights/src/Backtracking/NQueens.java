package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 12/20/2017.
 *
 * In chess, queens can move any number of squares vertically, horizontally, or diagonally.
 * The n-queens puzzle is the problem of placing n queens on an n × n chessboard so that no two queens can attack each other.

 Given an integer n, print all possible distinct solutions to the n-queens puzzle.
 Each solution contains distinct board configurations of the placement of the n queens,
 where the solutions are arrays that contain permutations of [1, 2, 3, .. n].
 The number in the ith position of the results array indicates that the ith column queen is placed in the row with that number.
 In your solution, the board configurations should be returned in lexicographical order.

 Example

 For n = 1, the output should be
 nQueens(n) = [[1]].

 For n = 4, the output should be

 nQueens(n) = [[2, 4, 1, 3],
 [3, 1, 4, 2]]
 */
public class NQueens {

    int[][] nQueens(int n) {
        if(n <= 0)
            return new int[0][0];

        int[][] board = new int[n][n];
        List<Integer> rows = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        solve(board, 0, rows, result);

        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    void solve(int[][] board, int col, List<Integer> rows, List<List<Integer>> result) {
        if(col == board.length) {
            result.add(new ArrayList<Integer>(rows));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(isValid(board, i, col)) {
                board[i][col] = 1;
                rows.add(i+1);
                solve(board, col+1, rows, result);
                board[i][col] = 0; //backtrack
                rows.remove(rows.size()-1);
            }
        }
    }

    boolean isValid(int[][] board, int row, int col) {
        for(int i = 0; i < col; i++)
            if(board[row][i] == 1) return false;

        for(int i = row, j = col; i >=0 && j >= 0; i--, j--)
            if(board[i][j] == 1) return false;

        for(int i = row, j = col; i < board.length && j >=0; i++, j--)
            if(board[i][j] == 1) return false;
        return true;
    }
}

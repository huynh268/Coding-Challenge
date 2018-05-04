package Array;

import java.util.HashSet;
/**
 * Created by Tien on 5/2/2018.
 *
 * https://leetcode.com/problems/valid-sudoku/description/https://leetcode.com/problems/valid-sudoku/description/
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 -Each row must contain the digits 1-9 without repetition.
 -Each column must contain the digits 1-9 without repetition.
 -Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:
 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true

 Example 2:
 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 Note:
 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.
 */
public class ValidSudoku36 {

    /**
     * O(n^2) Time complexity
     * O(n^2) Space
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int n = board[i][j] - '1';
                if(board[i][j] != '.') {
                    if(row[i][n] || column[j][n] || block[i - i%3 +j/3][n]) return false;
                    row[i][n] = true;
                    column[j][n] = true;
                    block[i - i%3 + j/3][n] = true;
                }
            }
        }

        return true;
    }


    /**
     * O(n^2) Time complexity
     * O(n^2) Space
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> hashSet = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    String checkRow = "row: " + i + board[i][j];
                    String checkCol = "col: " + j + board[i][j];
                    String checkBlock = "block: " + (i - i%3 + j/3) + board[i][j];
                    if(!hashSet.add(checkRow) || !hashSet.add(checkCol) || !hashSet.add(checkBlock)) return false;
                }
            }
        }

        return true;
    }
}

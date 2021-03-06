package BackTracking;

/**
 * Created by Tien on 3/13/2018.
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 */
public class WordSearch79 {

    /**
     * Backtracking
     * O(n*m*4^k) Time complexity - where n, m are board row and col lengths.
     *                            - there are 4 recursive calls for each step - 4^k
     * O(1) Space - Since there is no extra space used
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(check(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, char[] word, int row, int col, int i) {
        if(i == word.length) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(board[row][col] != word[i]) return false;

        board[row][col] = '*';
        boolean exist = check(board, word, row-1, col, i+1) ||
                        check(board, word, row+1, col, i+1) ||
                        check(board, word, row, col-1, i+1) ||
                        check(board, word, row, col+1, i+1);
        board[row][col] = word[i];
        return exist;
    }
}

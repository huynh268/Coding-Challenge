package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tien on 12/20/2017.
 *
 * Boggle is a popular word game in which players attempt to find words in sequences of adjacent letters on a rectangular board.

 Given a two-dimensional array board that represents the character cells of the Boggle board and an array of unique strings words,
 find all the possible words from words that can be formed on the board.

 Note that in Boggle when you're finding a word, you can move from a cell to any of its 8 neighbors, but you can't use the same cell twice in one word.

 Example

 For

 board = [
 ['R', 'L', 'D'],
 ['U', 'O', 'E'],
 ['C', 'S', 'O']
 ]
 and words = ["CODE", "SOLO", "RULES", "COOL"], the output should be
 wordBoggle(board, words) = ["CODE", "RULES"].
 */
public class WordBoggle {

    String[] wordBoggle(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String word : words) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    char[][] tmp = board;
                    if(solve(tmp, i, j, word) && !result.contains(word)) {
                        result.add(new String(word));
                    }
                }
            }
        }
        Collections.sort(result);
        return result.stream().toArray(String[]::new);
    }

    boolean solve(char[][] board, int row, int col, String word) {
        if(word.length() == 0) {
            return true;
        } else if (row < 0 || row >= board.length||
                col < 0 || col >= board[0].length||
                board[row][col] != word.charAt(0)) {
            return false;
        } else {
            char tmp = board[row][col];
            board[row][col] = '*';
            String s = word.substring(1);
            boolean res =   solve(board, row-1, col-1, s)||
                    solve(board, row+1, col+1, s)||
                    solve(board, row-1, col+1, s)||
                    solve(board, row+1, col-1, s)||
                    solve(board, row-1, col, s)||
                    solve(board, row+1, col, s)||
                    solve(board, row, col-1, s)||
                    solve(board, row, col+1, s);
            board[row][col] = tmp;
            return res;
        }

    }
}

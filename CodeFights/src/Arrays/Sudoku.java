package Arrays;

/**
 * Created by Tien on 11/10/2017.
 */
public class Sudoku {
    /**
     Arrays.Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row,
     and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

     Implement an algorithm that will check whether the given grid of numbers represents a valid Arrays.Sudoku puzzle according to the layout
     rules described above. Note that the puzzle represented by grid does not have to be solvable.

     Example
     For
     grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
     ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
     ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
     ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
     ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
     ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
     ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
     ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
     ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
     the output should be
     sudoku2(grid) = true;
     */
    public static boolean sudoku2(char[][] grid) {

        for(int i =0; i < grid.length; i++){
            int[] r = new int[10];
            int[] c = new int[10];
            int[] s = new int[10];

            for(int j = 0; j < grid.length; j++){

                //Check rows
                if((int)(grid[i][j]-'0')>0 && (int)(grid[i][j]-'0') <10){
                    if(r[(int)grid[i][j]-'0'] == 0){
                        r[(int)grid[i][j]-'0'] = 1;

                    }
                    else
                        return false;
                }

                //Check cols
                if((int)(grid[j][i]-'0')>0 && (int)(grid[j][i]-'0') <10){
                    if(c[(int)grid[j][i]-'0'] == 0)
                        c[(int)grid[j][i]-'0'] = 1;
                    else
                        return false;
                }

                //Check squares
                if((int)(grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3]-'0')>0
                        &&(int)(grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3]-'0')<10)
                    if(s[(int)grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3]-'0'] == 0)
                        s[(int)grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3]-'0'] = 1;
                    else
                        return false;
            }


        }

        return true;
    }

    public static void main(String[] args) {
        char[][] grid ={{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                        {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                        {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                        {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                        {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                        {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};

        System.out.println(sudoku2(grid));
    }
}

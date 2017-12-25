package DynamicProgrammingAdvanced;

/**
 * Created by Tien on 12/3/2017.
 * You have a 2D binary matrix that's filled with 0s and 1s. In the matrix, find the largest square that contains only 1s and return its area.

 Example

 For

 matrix = [
 ['1', '0', '1', '1', '1'],
 ['1', '0', '1', '1', '1'],
 ['1', '1', '1', '1', '1'],
 ['1', '0', '0', '1', '0'],
 ['1', '0', '0', '1', '0']
 ]
 the output should be
 maximalSquare(matrix) = 9.
 */
public class MaximalSquare {

    int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        if(r == 0) return 0;

        int c = matrix[0].length;
        int[][] dp = new int[r][c];

        int max = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = (int)matrix[i][j]-'0';
                } else if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1])+1;
                }
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }

        return max*max;
    }
}

import java.util.HashMap;

/**
 * Created by Tien on 1/29/2018.
 *
 * Count the total number of phone numbers that have length n
 * Rule: - number can't start with 0 and 1.
 *       - next number is the knight moves of current number on the phone pad. Ex: 0 -> 4,8; 1 -> 6,8; 2 -> 7,9; ...
 */
public class KnightMovesOnPhonePad {

    /**
     * Dynamic Programming
     *
     * 1 - Generate the Adjacency graph that shows the next moves - nodes (values) from current node (key) follows the knight's move
     *          EX: from 0 -> 4 or 6
     *              from 1 -> 6 or 8
     *              ..
     *
     * 2 - Generate the DP 2D array that has - n rows (n is the length of the phone number)
     *                                       - 10 columns (0-9 digits)
     *     dp[r][c] = the number of phone numbers that has r+1 length and c is their last digit
     *          EX: dp[0][0] = 0 since 0 can't start the number
     *              dp[0][1] = 0
     *              dp[0][4] = 1, the number of len 1 and last digit is 4: 4
     *              dp[2][4] = 2, the numbers of len 2 and last digit is 4: 34, 94
     *
     * 3 - Compute dp[i][j]: dp[i][values] += dp[i-1][key]
     *          Ex: dp[i][2] = dp[i][2] + dp[i-1][7] +dp[i-1][9] because 7 and 9 can make 2 at the next number
     *
     *
     * n = length of number
     * m = maximum number of values from any key - here is 3
     * O(m*n) Time complexity
     * O(n*10) Space
     * @param n
     * @return
     */
    public static long solution(int n) {

        //Adjacency graph
        //From KEY can move to VALUES
        //5 can't reach any others, the graph doesn't contain 5
        HashMap<Integer, int[]> hm = new HashMap<>();
        hm.put(0, new int[] {4,6}); //0
        hm.put(1, new int[] {6,8}); //1
        hm.put(2, new int[] {7,9}); //2
        hm.put(3, new int[] {4,8}); //3
        hm.put(4, new int[] {0,3,9}); //4
        hm.put(6, new int[] {0,1,7}); //6
        hm.put(7, new int[] {2,6}); //7
        hm.put(8, new int[] {1,3}); //8
        hm.put(9, new int[] {4,2}); //9


        long[][] dp = new long[n][10];

        //Initialize the 1st row
        for(int i = 0; i < 10; i++) {
            if(i == 0 || i == 1) dp[0][i] = 0;
            else dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= 9; j++) {
                if(j == 5) continue; //5 is not in the graph, so skip it
                for(int k : hm.get(j)) {
                    dp[i][k] += dp[i-1][j];
                }
            }
        }

        long sum = 0;
        for(int i = 0; i <= 9; i++){
            sum += dp[n-1][i];
        }
        return sum;
    }
}

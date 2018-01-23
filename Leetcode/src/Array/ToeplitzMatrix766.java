package Array;

import java.util.HashMap;

/**
 * Created by Tien on 1/22/2018.
 *
 * https://leetcode.com/problems/toeplitz-matrix/description/
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

 Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


 Example 1:

 Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 Output: True
 Explanation:
 1234
 5123
 9512

 In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 Example 2:

 Input: matrix = [[1,2],[2,2]]
 Output: False
 Explanation:
 The diagonal "[1, 2]" has different elements.
 Note:

 matrix will be a 2D array of integers.
 matrix will have a number of rows and columns in range [1, 20].
 matrix[i][j] will be integers in range [0, 99].
 */
public class ToeplitzMatrix766 {

    /**
     * O(n*m) Time complexity
     * O(1) Space
     * @param matrix
     * @return
     */
    boolean isToeplitzMatrix1(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j]) return false;
            }
        }
        return true;
    }

    /**
     * O(n*m) Time complexity
     * O(n) Space
     * (r1,c1) and (r2,c2) are in the same diagonal if and only if r1-c1 = r2-c2
     * @param matrix
     * @return
     */
    boolean isToeplitzMatrix2(int[][] matrix) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int diagonal = i - j;
                if(!hashMap.containsKey(i-j)) {
                    hashMap.put(diagonal, matrix[i][j]);
                } else {
                    if(hashMap.get(diagonal) != matrix[i][j]) return false;
                }
            }
        }
        return true;
    }
}

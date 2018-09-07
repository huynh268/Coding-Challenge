package BinarySearch;

/**
 * Created by Tien on 9/6/2018.
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 Example 1:
 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 3
 Output: true

 Example 2:
 Input:
 matrix = [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 target = 13
 Output: false

 */
public class Search2DMatrix74 {

    /**
     * Time complexity: O(m + logn), where m = row, and n = col
     * Space complexity: O(1)
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        int i = 1;
        while(i < matrix.length) {
            if(matrix[i][0] > target) break;
        }

        return binarySearch(matrix[i-1], target);
    }

    public boolean binarySearch(int[] a, int target) {
        int l = 0, r = a.length;
        while(l < r) {
            int m = l + (r-l)/2;
            if(a[m] == target) {
                return true;
            } else if (a[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return false;
    }
}

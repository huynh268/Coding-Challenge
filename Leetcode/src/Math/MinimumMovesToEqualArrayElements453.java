package Math;

/**
 * Created by Tien on 2/16/2018.
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/
 *
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

 Example:

 Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovesToEqualArrayElements453 {

    /**
     * O(n) Time complexity
     * O(1) Space
     *
     * m = moves
     * preSum = prefix sum of all elements in given array
     * min = value of min element in give array
     * v = value of elements after incrementing
     * n = size of array
     *
     * Since a move is incrementing n-1 elements by 1, which means every moves increases the preSum by amount n-1, and there are m moves, the total is m*(n-1)
     * Then we have an equation:
     *      preSum + m*(n-1) = v*n
     *      preSum + mn - m = (min + m)*n, since the smallest element has to move m moves to become v
     *      preSum + mn - m = min*n + mn
     * Therefore, m = preSum - min*n
     * @param nums
     * @return
     */
    int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int preSum = 0;
        for(int i : nums) {
            preSum += i;
            min = min < i ? min : i;
        }
        return preSum - min * nums.length;
    }
}

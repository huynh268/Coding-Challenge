/**
 * Created by Tien on 8/17/2018.
 */
public class BitManipulation {

    /**
     * 5.1
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
     * Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
     EXAMPLE:
     Input: N = 10000000000, M = 10101, i = 2, j = 6
     Output: N = 10001010100
     * @param n
     * @param m
     * @param i
     * @param j
     * @return
     */
    public int updateBits1(int n, int m, int i, int j) {
        //max = number with all 1's
        int allOnes = ~0;

        //1111000 - 1’s through position j, then 0’s
        //int left = allOnes << (j + 1);
        //int left = allOnes - ((1 << j)-1);
        int left = allOnes ^ ((1 << j)-1);

        //1’s after position i
        int right = ((1 << i)-1);

        // 1’s, with 0s between i and j
        int mask = left | right;

        // Clear i through j, then put m in there
        return (n & mask) | (m << i);
    }


    public int updateBits2(int n, int m, int i, int j) {
        int allOnes = ~0;

        allOnes <<= (j+1);
        allOnes |= ((1 << i) - 1);
        return (n & allOnes) | (m << i);
    }
}

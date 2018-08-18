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

    /**
     * 5.4
     *
     * Explain what the following code does: ((n & (n-1)) == 0).
     * n       = 1000000 is a power of 2
     * n-1     = 0111111
     * n&(n-1) = 0000000
     *
     * @param n
     * @return
     */
    public boolean isPowerOf2(int n) {
        return (n & (n-1)) == 0;
    }

    /**
     * 5.5
     *
     * Write a function to determine the number of bits required to convert integer A to integer B.
     Input: 31, 14
     Output: 2
     * @param a
     * @param b
     * @return
     */
    public int bitSwapRequired(int a, int b) {
        int count = 0;
        for(int xor = a^b; xor > 0; xor >>= 1) {
            count += (xor & 1);
        }
        return count;
    }

    /**
     * 5.6
     *
     * Write a program to swap odd and even bits in an integer with as few instructions as possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc).
     *
     * 0xaaaaaaaa = 10101010101010101010101010101010
     * 0x55555555 =  1010101010101010101010101010101
     *
     * x & 0xaaaaaaaa takes all odd bits in place
     * x & 0x55555555 tales all even bits in place
     * then shift to swap odd and even bits
     * @param x
     * @return
     */
    public int swapOddEvenBits(int x) {
        return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
    }
}

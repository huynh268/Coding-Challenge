package BitManipulation;

/**
 * Created by Tien on 1/12/2018.
 *
 *https://leetcode.com/problems/number-complement/description/
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:
 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 Example 1:
 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:
 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

 */
public class NumberComplement476 {

    /**
     * num = 5 = 101
     *   n = 7 = 111
     * n^num = 010 = 2
     *
     * num = 7 = 111
     *   n = 5 = 101
     * n^num = 000 = 0
     * @param num
     * @return
     */
    int findComplement1(int num) {
        int n = 1;
        while(n < num) {
            n <<= 1;
            n += 1;
        }

        return n^num;
    }

    /**
     * num = 5 = 00000101
     * mask=     11111000
     *
     * ~num=   = 11111010
     * ~mask=  = 00000111
     * ~mask & ~num = 010
     * @param num
     * @return
     */
    int findComplement2(int num) {
        int mask = Integer.MAX_VALUE;
        while((mask&num) != 0)
            mask <<= 1;

        return ~mask & ~num;
    }
}


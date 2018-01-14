package BitManipulation;

/**
 * Created by Tien on 1/13/2018.
 *
 *https://leetcode.com/problems/number-of-1-bits/description/
 *
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits191 {

    /**
     * 2147483648 is represented as -2147483647 (Integer.MAX_VALUE + 1 = Integer.MIN_VALUE)
     * 2147483648  = 1000 0000 0000 0000 0000 0000 0000 0000
     * Therefore n > 0 does not work.
     * @param n
     * @return
     */
    int hammingWeight1(int n) {
        int count = 0;

        while(n != 0) {
            count += n&1;
            n >>>= 1; // >>> bit shifting unsigned operation, since n could be negative, we can't use >>.
        }

        return count;
    }

    int hammingWeight2(int n) {
        int count = 0;

        while( n!= 0) {
            count++;
            n = n & (n-1);
        }

        return count;
    }
}

package BitManipulation;

/**
 * Created by Tien on 1/13/2018.
 *
 *
 *
 *
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

 Example 1:
 Input: 5
 Output: True
 Explanation:
 The binary representation of 5 is: 101

 Example 2:
 Input: 7
 Output: False
 Explanation:
 The binary representation of 7 is: 111.

 Example 3:
 Input: 11
 Output: False
 Explanation:
 The binary representation of 11 is: 1011.

 Example 4:
 Input: 10
 Output: True
 Explanation:
 The binary representation of 10 is: 1010.
 */
public class BinaryNumberWithAlternatingBits693 {

    /**
     * n    = 101010
     * n>>1 =  10101
     * n ^ (n>>1) = 111111
     *
     * n    = 11101011
     * n>>1 =  1110101
     * n ^ (n>>1) = 10011110
     * @param n
     * @return
     */
    boolean hasAlternatingBits(int n) {
        n ^= n>>1;

        while(n > 0) {
            if((n & 1) == 0)
                return false;
            n >>= 1;
        }

        return true;
    }
}

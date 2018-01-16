/**
 * Created by Tien on 1/14/2018.
 *
 *
 *
 * Given two integers L and R, find the count of numbers in the range [L, R] (inclusive)
 * having a prime number of set bits in their binary representation.

 (Recall that the number of set bits an integer has is the number of 1s present when written in binary.
 For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

 Example 1:

 Input: L = 6, R = 10
 Output: 4
 Explanation:
 6 -> 110 (2 set bits, 2 is prime)
 7 -> 111 (3 set bits, 3 is prime)
 9 -> 1001 (2 set bits , 2 is prime)
 10->1010 (2 set bits , 2 is prime)
 Example 2:

 Input: L = 10, R = 15
 Output: 5
 Explanation:
 10 -> 1010 (2 set bits, 2 is prime)
 11 -> 1011 (3 set bits, 3 is prime)
 12 -> 1100 (2 set bits, 2 is prime)
 13 -> 1101 (3 set bits, 3 is prime)
 14 -> 1110 (3 set bits, 3 is prime)
 15 -> 1111 (4 set bits, 4 is not prime)
 Note:

 L, R will be integers L <= R in the range [1, 10^6].
 R - L will be at most 10000.
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation762 {

    /**
     * R-L = M
     * O(M*(sqrt(n) + logn)) ~ O(N^2)
     * O(1) Space
     * @param L
     * @param R
     * @return
     */
    int countPrimeSetBits1(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++) {
            if(isPrime(countBits(i))) count++;
        }
        return count;
    }

    /**
     * O(logn) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    int countBits(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n&(n-1);
        }
        return count;
    }

    /**
     * O(sqrt(n)) Time complexity
     * 0(1) space
     * @param n
     * @return
     */
    boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n <= 3) return true;

        if(n%2 == 0 || n%3 == 0) return false;

        for(int i = 5; i*i <= n; i += 6) {
            if(n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }

    /**********************************************************************************************************/
    /**
     * R-L = M
     * O(M) Time complexity
     * O(1) Space
     *
     * Since n <= 10^6 < 2^32-1 = Integer.MAX_VALUE, there are at most 32 bits.
     * Therefore the maximum value bitcount is 32. And only 10 prime numbers less than 32
     * p = {2,3,5,7,11,13,17,19,23,29}
     *
     * @param L
     * @param R
     * @return
     */
    int countPrimeSetBits2(int L, int R) {
        int count = 0;
        for(int i = L; i <= R; i++) {
            if(isPrime2(i)) count++;
        }

        return count;
    }

    /**
     * O(1) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    boolean isPrime2(int n) {
        return n == 2 || n == 3 || n == 5 ||
                n == 7 || n == 11 || n == 13 ||
                n == 17 || n == 19 || n == 23 ||
                n == 29;
    }
}

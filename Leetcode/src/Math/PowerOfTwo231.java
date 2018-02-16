package Math;

/**
 * Created by Tien on 2/15/2018.
 *
 * https://leetcode.com/problems/power-of-two/description/
 *
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo231 {

    /**
     * Iterative
     * O(logn) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    boolean isPowerOfTwo1(int n) {
        if(n == 0) return false;
        while(n%2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    /**
     * Recursive
     * O(logn) Time complexity
     * O(n) Space;
     * @param n
     * @return
     */
    boolean isPowerOfTwo2(int n) {
        return n > 0 && (n == 1 || n%2 == 0 && isPowerOfTwo2(n/2));
    }

    /**
     * Bit manipulation
     * O(1) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    boolean isPowerOfTwo3(int n) {
        return (n&(n-1)) == 0 && n > 0;
    }
}


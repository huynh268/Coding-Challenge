package Math;

/**
 * Created by Tien on 2/15/2018.
 *
 * https://leetcode.com/problems/power-of-four/description/
 *
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour342 {

    /**
     * Iterative
     * O(logn) Time complexity
     * O(1) Space
     * @param num
     * @return
     */
    boolean isPowerOfFour1(int num) {
        if(num == 0) return false;
        while(num%4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * Recursive
     * O(logn) Time complexity
     * O(n) Space
     * @param num
     * @return
     */
    boolean isPowerOfFour2(int num) {
        return num > 0 && (num == 1 || num%4 == 0 && isPowerOfFour2(num/4));
    }

    /**
     * O(1) Time complexity
     * O(1) Space
     *
     * 0x55555555 = 1010101010101010101010101010101
     * 4^n has the bit 1 at odd position, ex: 1 = 1, 4 = 100, 16 = 10000
     * num > 0 && (num & (num-1)) == 0 to check if num is power of 2
     * (num & 0x55555555) != 0 check if the bit 1 in num is at odd position
     * @param num
     * @return
     */
    boolean isPowerOfFour3(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
    }

    /**
     * O(1) Time complexity
     * O(1) Space
     *
     * Proof1: (4^n - 1) % 3 = 0, for every integer n >= 0
     * 4^n - 1 = (4 - 1)(4^(n-1) + 4^(n-2) + ... + 4 + 1) = 3*(4^(n-1) + 4^(n-2) + ... + 4^1 + 1) % 3 = 0
     *
     * Proof2: (4^n - 1) % 3 = 0, for every integer n >= 0
     * Induction:
     * 4^1 - 1 = 3%3 = 0
     * 4^2 - 1 = 15%3 = 0
     * Suppose that (4^n-1) % 3 = 0, for integer n >= 0
     * Prove that (4^(n+1) - 1) % 3 = 0, for integer n + 1 >= 0
     * 4^(n+1) - 1 = 4*4^n - 1 = 4*4^n - (4 - 3) = (4*(4^n - 1) + 3) % 3 = 0, since (4^n-1) % 3 = 0 (Induction hypothesis)
     *
     * @param num
     * @return
     */
    boolean isPowerOfFour4(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num - 1) % 3 == 0;
    }
}

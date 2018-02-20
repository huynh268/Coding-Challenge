package Math;

/**
 * Created by Tien on 2/18/2018.
 *
 * https://leetcode.com/problems/power-of-three/description/
 *
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class PowerOfThree326 {

    /**
     * O(logn) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    boolean isPowerOfThree1(int n) {
        if(n == 0) return false;
        while(n%3 == 0)
            n /= 3;
        return n == 1;
    }

    /**
     * LOGa(b) = LOGc(b) / LOGc(a)
     * @param n
     * @return
     */
    boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

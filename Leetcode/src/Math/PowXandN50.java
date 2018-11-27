package Math;

/**
 * Created by Tien on 8/24/2018.
 *
 * https://leetcode.com/problems/powx-n/description/
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:
 Input: 2.00000, 10
 Output: 1024.00000

 Example 2:
 Input: 2.10000, 3
 Output: 9.26100

 Example 3:
 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25

 Note:
 -100.0 < x < 100.0
 n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class PowXandN50 {

    /**
     * Time comeplxity: O(log n)
     * Space complexity: O(1)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n == 0) return 1;

        // x^n with n < 0 = (1/x)^(-n)
        //if n is negative, make it positive and change value of x to 1/x
        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        double pow = 1;
        while(n != 0) {

            //n is odd
            //4^5 = 4*4^2 = 4*16
            if((n&1) == 0) {
                pow *= x;
            }
            x *= x;

            //since n = -n could cause overflow e.g. n = -2147483648 => -n = 2147483648 overflow!!!
            //divide n by 2 with unsigned shift to avoid overflows
            n >>>= 1;
        }

        return pow;
    }
}

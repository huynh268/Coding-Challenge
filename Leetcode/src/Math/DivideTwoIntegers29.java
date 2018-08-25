package Math;

/**
 * Created by Tien on 8/24/2018.
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 Return the quotient after dividing dividend by divisor.
 The integer division should truncate toward zero.

 Example 1:
 Input: dividend = 10, divisor = 3
 Output: 3

 Example 2:
 Input: dividend = 7, divisor = -3
 Output: -2

 Note:
 Both dividend and divisor will be 32-bit signed integers.
 The divisor will never be 0.
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */
public class DivideTwoIntegers29 {

    public int divide(int dividend, int divisor) {
        if(divisor == 0) return -1;
        if(divisor == 1) return dividend;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor == -1) return -dividend;

        int sign = 1;

        //if dividend and divisor dont have the same sign, then the quotient must be negative.
        if((dividend > 0) ^ (divisor > 0)) sign = -1;

        //Make divisor and dividend negative to avoid overflows
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int quotient = 0;
        while(dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return sign > 0? quotient : -quotient;
    }
}

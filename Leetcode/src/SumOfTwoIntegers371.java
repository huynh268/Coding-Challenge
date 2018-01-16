/**
 * Created by Tien on 1/15/2018.
 *
 * https://leetcode.com/problems/sum-of-two-integers/description/
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers371 {

    int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;

        int carry = 0;
        while(b != 0) {
            carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
}

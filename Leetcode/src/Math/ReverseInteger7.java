package Math;

/**
 * Created by Tien on 1/14/2018.
 *
 *https://leetcode.com/problems/reverse-integer/description/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321
 Example 2:

 Input: -123
 Output: -321
 Example 3:

 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger7 {

    int reverse(int x) {
        int n = 0;

        while(x != 0) {
            if(n > Integer.MAX_VALUE/10 || n < Integer.MIN_VALUE/10) return 0;
            n = n*10 + x%10;
            x /= 10;
        }

        return n;
    }
}

package Math;

/**
 * Created by Tien on 3/5/2018.
 *
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

 Example:
 Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigits357 {

    /**
     * O(n) Time complexity
     * O(1) Space
     *
     * n = 0 - 0       - 1 number
     *
     * n = 1 - [1,9]   - 10 numbers
     *
     * n = 2 - [10,98] - 81 numbers, excluding [11,22,33,44,55,66,77,88,99]
     *                 - 1st digit has 9 ways to choose
     *                 - 2nd digits has 9 ways to choose
     *                 => 9*9 numbers
     *
     * n = 3           - 1st digit has 9 ways to choose
     *                 - 2nd digit has 9 ways to choose
     *                 - 3rd digit has 8 ways to choose
     *                 => 9*9*8 numbers
     * .
     * .
     * .
     *
     * n = 10          - 1st digit has 9 ways to choose
     *                 - 2nd digit has 9 ways to choose
     *                 - 3rd digit has 8 ways to choose
     *                 .
     *                 .
     *                 .
     *                 - 10th digit has 1 way to choose
     *                 => 9*9*8*7*6*5*4*3*2*1 numbers
     * @param n
     * @return
     */
    int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        if(n >= 11) return 0;

        int ans = 10, base = 9;
        for(int i = 2; i <= n; i++) {
            base = base*(9 - i + 2);
            ans += base;
        }
        return ans;
    }
}

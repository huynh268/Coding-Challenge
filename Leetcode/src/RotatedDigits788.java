/**
 *
 * https://leetcode.com/problems/rotated-digits/description/
 *
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other;
 * 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number.

 Now given a positive number N, how many numbers X from 1 to N are good?

 Example:
 Input: 10
 Output: 4
 Explanation:
 There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 Note:

 N  will be in range [1, 10000].
 */
public class RotatedDigits788 {

    /**
     * O(Nlogn) Time complexity
     * O(Nlogn) Space
     * @param N
     * @return
     */
    int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1; i <= N; i++)
            if(isValid(i)) count++;
        return count;
    }

    boolean isValid(int n) {
        String s = n + "";
        return s.matches(".*[2569].*") && !s.matches(".*[347].*");
    }
}

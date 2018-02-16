package Math;

/**
 * Created by Tien on 2/15/2018.
 *
 * https://leetcode.com/problems/base-7/description/
 *
 * Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"

 Example 2:
 Input: -7
 Output: "-10"

 Note: The input will be in range of [-1e7, 1e7].
 */
public class BaseSeven504 {

    /**
     * Recursive
     * O(logn) Time complexity
     * O(n) Space
     * @param num
     * @return
     */
    String convertToBase71(int num) {
        if(num < 0) return "-" + convertToBase71(-num);
        if(num < 7) return "" + num;
        return convertToBase71(num/7) + num%7;
    }

    /**
     * Iterative
     * O(logn) Time complexity
     * O(1) Space
     * @param num
     * @return
     */
    String convertToBase72(int num) {
        String sign = num >= 0 ? "" : "-";
        if(num < 0) num = -num;
        if(num == 0) return "" +num;
        String ans = "";
        while(num > 0) {
            ans = num%7 + ans;
            num /= 7;
        }
        return sign + ans;
    }

    /**
     * Built-in function
     * @param num
     * @return
     */
    String convertToBase73(int num) {
        return Integer.toString(num, 7);
    }
}

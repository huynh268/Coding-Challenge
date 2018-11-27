package String;

/**
 * Created by Tien on 9/13/2018.
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * Given two binary strings, return their sum (also a binary string).

 The input strings are both non-empty and contains only characters 1 or 0.

 Example 1:

 Input: a = "11", b = "1"
 Output: "100"
 Example 2:

 Input: a = "1010", b = "1011"
 Output: "10101"
 */
public class AddBinary67 {

    /**
     * Iteration
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = ca.length-1, j = cb.length-1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0) {
            if(i >= 0) carry += ca[i--] - '0';
            if(j >= 0) carry += cb[j--] - '0';
            sb.append(carry%2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }

    /**
     * Recursion
     *
     * Time comeplexity: O(2^n)
     * Space complexity: O(2^n)
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        int n = a.length();
        int m = b.length();

        if(n == 0 || m == 0) return a + b;
        if(a.charAt(n-1) == '1' && b.charAt(m-1) == '1') {
            return addBinary2(addBinary2(a.substring(0, n-1), b.substring(0, m-1)), "1") + "0";
        }
        if(a.charAt(n-1) == '0' && b.charAt(m-1) == '0') {
            return addBinary2(a.substring(0, n-1), b.substring(0, m-1)) + "0";
        }

        return addBinary2(a.substring(0, n-1), b.substring(0, m-1)) + "1";
    }
}

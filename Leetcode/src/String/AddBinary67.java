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
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
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
}

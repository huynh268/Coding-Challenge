package String;

/**
 * Created by Tien on 1/11/2018.
 *
 *https://leetcode.com/problems/multiply-strings/description/
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:

 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings43 {

    String multiply(String n1, String n2) {
        if(n1.equals("0") || n2.equals("0")) return "0";
        int i = n2.length()-1;
        String j = "";
        String ans = "";
        while(i >= 0) {
            String mul = mul(n1, n2.charAt(i));
            j += n2.length()-1 == i? "" : 0;
            ans = add(ans, mul + j);
            i--;
        }
        return ans;
    }

    String add(String num1, String num2) {
        int carry = 0;
        String ans = "";
        int i = num1.length()-1, j = num2.length()-1;

        while(i >= 0 || j >=0 || carry != 0) {
            if(i >= 0) {
                carry += num1.charAt(i--)-'0';
            }
            if(j >= 0) {
                carry += num2.charAt(j--)-'0';
            }

            ans = carry%10 + ans;
            carry /= 10;
        }

        return ans;
    }

    String mul(String n1, char n2) {
        if(n2 == '0') return "0";
        String ans = "";
        int i = n1.length()-1;
        int carry = 0;

        while(i >= 0 || carry > 0) {
            if(i >= 0) carry += (n2 - '0')*(n1.charAt(i--)-'0');

            ans = carry%10 + ans;
            carry /= 10;
        }
        return ans;
    }
}

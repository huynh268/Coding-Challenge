package String;

/**
 * Created by Tien on 1/11/2018.
 *
 *https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

 Example 1:
 Input: "aba"
 Output: True

 Example 2:
 Input: "abca"
 Output: True
 Explanation: You could delete the character 'c'.

 Note:
 The string will only contain lowercase characters a-z. The maximum length of the string is 50000.

 */
public class ValidPalindromeII680 {

    boolean validPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            int j = s.length()-1-i;
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }

    boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}

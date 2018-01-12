package String;

/**
 * Created by Tien on 1/11/2018.
 *
 *https://leetcode.com/problems/valid-palindrome/description/
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome125 {
    boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^0-9a-zA-Z]","");

        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }

        return true;
    }
}

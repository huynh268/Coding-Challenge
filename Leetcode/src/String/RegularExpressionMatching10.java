package String;

/**
 * Created by Tien on 2/1/2018.
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching10 {

    boolean isMatch(String text, String pattern) {
        if(pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if(pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text,pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}

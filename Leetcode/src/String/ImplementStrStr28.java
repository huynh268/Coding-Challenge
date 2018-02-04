package String;

/**
 * Created by Tien on 2/3/2018.
 *
 * https://leetcode.com/problems/implement-strstr/description/
 *
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 */
public class ImplementStrStr28 {

    /**
     * Brute force
     * O(n^2) Time complexity
     * O(1) Space
     * @param haystack
     * @param needle
     * @return
     */
    int strStr(String haystack, String needle) {
        for(int i = 0; ; i++) {
            for(int j = 0; ; j++) {
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
    }
}

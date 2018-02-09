package String;

/**
 * Created by Tien on 2/9/2018.
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class ReverseVowelsOfaString345 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param str
     * @return
     */
    String reverseVowels(String str) {
        char[] c = str.toCharArray();
        int start = 0, end = c.length - 1;
        while(start < end) {
            if(!isVowel(c[start])) start++;
            else if(!isVowel(c[end])) end--;
            else {
                char tmp = c[start];
                c[start++] = c[end];
                c[end--] = tmp;
            }
        }
        return new String(c);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'U' || c == 'O';
    }
}

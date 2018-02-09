package String;

/**
 * Created by Tien on 2/8/2018.
 *
 *
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 Example:
 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 Restrictions:
 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class ReverseStringII541 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param str
     * @param k
     * @return
     */
    String reverseStr(String str, int k) {
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i += 2*k) {
            int start = i;
            int end = Math.min(start + k -1, c.length-1);
            while(start < end) {
                char tmp = c[start];
                c[start++] = c[end];
                c[end--] = tmp;
            }
        }
        return new String(c);
    }
}

package String;

/**
 * Created by Tien on 8/28/2018.
 *
 * https://leetcode.com/problems/to-lower-case/description/
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 Example 1:
 Input: "Hello"
 Output: "hello"

 Example 2:
 Input: "here"
 Output: "here"

 Example 3:
 Input: "LOVELY"
 Output: "lovely"
 */
public class ToLowerCase709 {

    public String toLowerCase1(String str) {
        char[] chars = str.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] >= 'A' && chars[i] <= 'Z')
                chars[i] = (char)(chars[i] - 'A' + 'a');
        }

        return new String(chars);
    }

    public String toLowerCase2(String str) {
        StringBuilder sb = new StringBuilder();

        for(char c : str.toCharArray()) {
            if('A' <= c && c >= 'Z') c = (char)(c - 'A' + 'a');
            sb.append(c);
        }

        return sb.toString();
    }
}

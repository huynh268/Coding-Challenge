package String;

/**
 * Created by Tien on 6/2/2018.
 *
 * https://leetcode.com/problems/backspace-string-compare/description/
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

 Example 1:
 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".

 Example 2:
 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".

 Example 3:
 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".

 Example 4:
 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".


 Note:
 1 <= S.length <= 200
 1 <= T.length <= 200
 S and T only contain lowercase letters and '#' characters.
 */
public class BackspaceStringCompare844 {

    /**
     * String Builder
     * O(S + T) Time complexity
     * O(S + T) Space
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != '#') {
                s.append(S.charAt(i));
            } else if (S.charAt(i) == '#' && s.length() > 0) {
                s.deleteCharAt(s.length()-1);
            }
        }

        for(int i = 0; i < T.length(); i++) {
            if(T.charAt(i) != '#') {
                t.append(T.charAt(i));
            } else if (T.charAt(i) == '#' && t.length() > 0) {
                t.deleteCharAt(t.length()-1);
            }
        }
        return s.toString().equals(t.toString());
    }
}

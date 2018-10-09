package String;

/**
 * Created by Tien on 10/8/2018.
 *
 * https://leetcode.com/problems/reverse-only-letters/description/
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



 Example 1:
 Input: "ab-cd"
 Output: "dc-ba"

 Example 2:
 Input: "a-bC-dEf-ghIj"
 Output: "j-Ih-gfE-dCba"

 Example 3:
 Input: "Test1ng-Leet=code-Q!"
 Output: "Qedo1ct-eeLg=ntse-T!"


 Note:
 S.length <= 100
 33 <= S[i].ASCIIcode <= 122
 S doesn't contain \ or "
 */
public class ReverseOnlyLetters917 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     * @param S
     * @return
     */
    public String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int i = 0, j = S.length()-1;

        while(i < j) {
            if(!Character.isLetter(c[i])) {
                i++;
                continue;
            }
            if(!Character.isLetter(c[j])) {
                j--;
                continue;
            }
            char tmp = c[i];
            c[i++] = c[j];
            c[j--] = tmp;
        }

        return new String(c);
    }
}

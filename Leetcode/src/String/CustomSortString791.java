package String;

/**
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

 S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted.
 More specifically, if x occurs before y in S, then x should occur before y in the returned string.

 Return any permutation of T (as a string) that satisfies this property.

 Example :
 Input:
 S = "cba"
 T = "abcd"
 Output: "cbad"
 Explanation:
 "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


 Note:

 S has length at most 26, and no character is repeated in S.
 T has length at most 200.
 S and T consist of lowercase letters only.
 */
public class CustomSortString791 {

    /**
     * O(S+T) Time complexity
     * O(S+T) Space
     * @param S
     * @param T
     * @return
     */
    String customSortString1(String S, String T) {
        int[] countChar = new int[26];
        for(char c : T.toCharArray()) {
            countChar[c - 'a']++;
        }

        String ans = "";
        for(char c : S.toCharArray()) {
            for(int i = 0; i < countChar[c - 'a']; i++) {
                ans += c;
            }
            countChar[c - 'a'] = 0;
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < countChar[i]; j++) {
                ans += (char)(i +'a'));
            }
        }

        return ans;
    }

    /**
     * Using StringBuilder instead of String Concatenation - which is much more efficient
     * O(S+T) Time complexity
     * O(S+T) Space
     * @param S
     * @param T
     * @return
     */
    String customSortString2(String S, String T) {
        int[] countChar = new int[26];
        for(char c : T.toCharArray()) {
            countChar[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            for(int i = 0; i < countChar[c - 'a']; i++) {
                sb.append(c);
            }
            countChar[c - 'a'] = 0;
        }

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < countChar[i]; j++) {
                sb.append((char)(i + 'a'));
            }
        }

        return sb.toString();
    }
}

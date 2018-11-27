package String;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Example 1:
 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", which the length is 3.

 Example 2:
 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.

 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Created by Tien on 8/23/2018.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;

        for(int i = 0, j = 0; j < s.length(); j++) {
            if(hm.containsKey(s.charAt(j))) {
                i = Math.max(i, hm.get(s.charAt(j)) + 1);
            }
            max = Math.max(max, j - i + 1);
            hm.put(s.charAt(j), j);
        }

        return max;
    }

    /**
     * Time comeplexity: O(n)
     * Space complexity: O(1)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int[] seen = new int[256];
        int max = 0;

        for(int i = 0, j = 0; j < s.length(); j++) {
            if(seen[s.charAt(j)] != 0) {
                i = Math.max(i, seen[s.charAt(j)]);
            }
            max = Math.max(max, j - i + 1);
            seen[s.charAt(j)] = j + 1;
        }

        return max;
    }
}

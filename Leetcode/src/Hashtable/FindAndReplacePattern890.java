package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 8/27/2018.
 *
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 *
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 Return a list of the words in words that match the given pattern.
 You may return the answer in any order.


 Example 1:
 Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 Output: ["mee","aqq"]
 Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 since a and b map to the same letter.


 Note:
 1 <= words.length <= 50
 1 <= pattern.length = words[i].length <= 20
 */
public class FindAndReplacePattern890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            if(isMatch1(pattern, word)) ans.add(word);
        }
        return ans;
    }

    /**
     * Space complexity: O(n)
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isMatch1(String a, String b) {
        if(a.length() != b.length()) return false;

        HashMap<Character, Character> hm1 = new HashMap<>();
        HashMap<Character, Character> hm2 = new HashMap<>();

        for(int i = 0; i < a.length(); i++) {
            if(!hm1.containsKey(a.charAt(i))) hm1.put(a.charAt(i), b.charAt(i));
            if(!hm2.containsKey(b.charAt(i))) hm2.put(b.charAt(i), a.charAt(i));
            if(hm1.get(a.charAt(i)) != b.charAt(i) ||
                    hm2.get(b.charAt(i)) != a.charAt(i)) return false;
        }

        return true;
    }

    /**
     * Space complexity: O(1)
     *
     * @param a
     * @param b
     * @return
     */
    private boolean isMatch2(String a, String b) {
        if(a.length() != b.length()) return false;

        int[] match = new int[52];

        for(int i = 0; i < a.length(); i++){
            int ca = a.charAt(i) - 'a';
            int cb = b.charAt(i) - 'a' + 26;
            if(match[ca] != match[cb]) return false;
            match[ca] = i + 1;
            match[cb] = i + 1;
        }

        return true;
    }
}

package Hashtable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Tien on 4/14/2018.
 *
 * https://leetcode.com/problems/most-common-word/description/
 *
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

 Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive. The answer is in lowercase.

 Example:
 Input:
 paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 banned = ["hit"]
 Output: "ball"
 Explanation:
 "hit" occurs 3 times, but it is a banned word.
 "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 Note that words in the paragraph are not case sensitive,
 that punctuation is ignored (even if adjacent to words, such as "ball,"),
 and that "hit" isn't the answer even though it occurs more because it is banned.


 Note:
 1 <= paragraph.length <= 1000.
 1 <= banned.length <= 100.
 1 <= banned[i].length <= 10.
 The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
 paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 Different words in paragraph are always separated by a space.
 There are no hyphens or hyphenated words.
 Words only consist of letters, never apostrophes or other punctuation symbols.
 */
public class MostCommonWord819 {

    /**
     * Hash table
     * n = paragraph.length()
     * m = banned.length()
     * O(n + m) Time complexity
     * O(n + m) Space complexity
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z ]", "");
        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        for(String word : banned) hashSet.add(word);

        int maxCount = 0;
        String ans = "";
        for(String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            if(hashMap.get(word) > maxCount && !hashSet.contains(word)) {
                ans = word;
                maxCount = hashMap.get(word);
            }
        }

        return ans;
    }
}

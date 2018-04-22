package Hashtable;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Tien on 4/21/2018.
 *
 * https://leetcode.com/problems/short-encoding-of-words/description/
 *
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

 For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

 Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

 What is the length of the shortest reference string S possible that encodes the given words?

 Example:
 Input: words = ["time", "me", "bell"]
 Output: 10
 Explanation: S = "time#bell#" and indexes = [0, 2, 5].

 Note:
 1 <= words.length <= 2000.
 1 <= words[i].length <= 7.
 Each word has only lowercase letters.

 */
public class ShortEncodingOfWords820 {

    /**
     * O(W) Time complexity - W = Sum(word.length() in words)
     * O(W) Space
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        for(String word : words) {
            for(int i = 1; i < word.length(); i++) {
                hashSet.remove(word.substring(i));
            }
        }

        int ans = 0;
        for(String word : hashSet) {
            ans += word.length() + 1;
        }

        return ans;
    }
}

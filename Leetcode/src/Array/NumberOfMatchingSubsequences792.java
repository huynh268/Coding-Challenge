package Array;

/**
 * Created by Tien on 3/3/2018.
 *
 * https://leetcode.com/problems/number-of-matching-subsequences/description/
 *
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

 Example :
 Input:
 S = "abcde"
 words = ["a", "bb", "acd", "ace"]
 Output: 3
 Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 Note:

 All words in words and S will only consists of lowercase letters.
 The length of S will be in the range of [1, 50000].
 The length of words will be in the range of [1, 5000].
 The length of words[i] will be in the range of [1, 50].
 */
public class NumberOfMatchingSubsequences792 {

    /**
     * O(n^2) Time complexity
     * O(1) Space
     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            if(isSubseq(S, words[i])) count++;
        }
        return count;
    }

    /**
     * O(m + n) Time complexity, m = a.length() and n = b.length()
     * O(1) Space
     * @param a
     * @param b
     * @return
     */
    private boolean isSubseq(String a, String b) {
        int i = 0, j = 0;
        while(i < a.length() && j < b.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == b.length();
    }
}

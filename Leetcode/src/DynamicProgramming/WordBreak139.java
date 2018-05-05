package DynamicProgramming;

import java.util.List;
import java.util.HashSet;

/**
 * Created by Tien on 5/4/2018.
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.

 Note:
 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.

 Example 1:
 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".

 Example 2:
 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.

 Example 3:
 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false
 */
public class WordBreak139 {

    /**
     * O(m*n^2) Time complexity - where m = length of wordDict and n = length of s
     * O(n) Space
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i < s.length() + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    /**
     * O(m*n^2) Time complexity - where m = length of wordDict and n = length of s
     * O(n) Space
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        for(String word : wordDict) set.add(word);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i < s.length() + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

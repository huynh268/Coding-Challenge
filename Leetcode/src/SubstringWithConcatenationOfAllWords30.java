import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 5/8/2018.
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 Example 1:

 Input:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 Output: [0,9]
 Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 The output order does not matter, returning [9,0] is fine too.
 Example 2:

 Input:
 s = "wordgoodstudentgoodword",
 words = ["word","student"]
 Output: []
 */
public class SubstringWithConcatenationOfAllWords30 {

    /**
     * Time complexity: O((N-M)*M
     * Space complexity: O((N-M)*M
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int N = s.length();
        int numWords = words.length;

        if(numWords == 0) return ans;

        int wordLen = words[0].length();
        int M = numWords * wordLen;

        HashMap<String, Integer>  hashMap = new HashMap<>();
        for(String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i <= N - M; i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;

            while(j < numWords) {
                String word = s.substring(i + j * wordLen, i + (j+1) * wordLen);
                if(!hashMap.containsKey(word)) break;

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if(seen.get(word) > hashMap.get(word)) break;

                j++;
            }

            if(j == numWords) ans.add(i);
        }

        return ans;
    }


    /**
     * Rolling Hash - Rabin Karp Algorithm
     *
     * Time complexity: O((N-M)*M)
     * Space complexity: O((N-M)*M)
     * 
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int N = s.length();
        int numWords = words.length;

        if(numWords == 0) return ans;

        int wordLen = words[0].length();
        int M = numWords * wordLen;
        if(N < M) return ans;

        //variables for hashing
        int p = 257; //Prime number
        int hashWords = 0; //Hash value of all words in words
        int hashWindow = 0; //Hash value of each window of s

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);

            //calculate hash value of all words in words
            for(char c : word.toCharArray()) {
                hashWords = (hashWords + c)%p;
            }
        }

        //Calculate hash value of 1st window of s
        for(int i = 0; i < M; i++) {
            hashWindow = (hashWindow + s.charAt(i))%p;
        }

        for(int i = 0; i <= N-M; i++) {
            if(hashWords == hashWindow) {

                HashMap<String, Integer> seen = new HashMap<>();
                int j = 0;
                while (j < numWords) {
                    String word = s.substring(i + j * wordLen, i + (j+1) * wordLen);
                    if(!hashMap.containsKey(word)) break;

                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if(seen.get(word) > hashMap.get(word)) break;

                    j++;
                }

                if(j == numWords) ans.add(i);

            }

            //Calculate hash value for new window
            if(i < N - M){
                hashWindow = (hashWindow - s.charAt(i) + s.charAt(i + M)) % p;
                if(hashWindow < 0) hashWindow += p;
            }
        }

        return ans;
    }
}

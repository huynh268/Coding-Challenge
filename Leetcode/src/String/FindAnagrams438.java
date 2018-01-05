package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 1/4/2018.
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAnagrams438 {

    /**
     * Based on Rabin-Karp Algorithm
     * O(n+m) Time complexity for Average and Best case
     * O(n*m) Worst case
     * @param s
     * @param p
     * @return
     */
    List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int prime = 101;
        int hashS = 0;
        int hashP = 0;
        int n = s.length();
        int m = p.length();

        if(n < m || n == 0)
            return ans;

        //Hash the 1st window
        for(int i = 0; i < m; i++) {
            hashP = (hashP + p.charAt(i))%prime;
            hashS = (hashS + s.charAt(i))%prime;
        }

        for(int i = 0; i <= n - m; i++) {
            if(hashP == hashS) {
                if(isAnagram(s.substring(i, i+m), p))
                    ans.add(i);
            }

            if(i < n - m){
                hashS = (hashS - s.charAt(i) + s.charAt(i+m))%prime;

                //if hashS < 0, then make it positive by adding prime
                if(hashS < 0)
                    hashS += prime;
            }
        }

        return ans;
    }

    boolean isAnagram(String a, String b) {
        if(a == null || b == null || a.length() != b.length())
            return false;

        int[] c = new int[26];

        for(int i = 0; i < a.length(); i++) {
            c[a.charAt(i) - 'a']++;
        }

        for(int i = 0; i < b.length(); i++) {
            c[b.charAt(i) -'a']--;
            if(c[b.charAt(i)-'a'] < 0)
                return false;
        }

        return true;
    }
}

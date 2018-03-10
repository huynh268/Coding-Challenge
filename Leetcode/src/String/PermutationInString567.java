package String;

/**
 * Created by Tien on 3/9/2018.
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 Example 1:
 Input:s1 = "ab" s2 = "eidbaooo"
 Output:True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:
 Input:s1= "ab" s2 = "eidboaoo"
 Output: False
 Note:
 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].
 */
public class PermutationInString567 {

    /**
     * O(n + m) Time complexity in average case
     * O(m*n) Time complexity in worst case
     * O(1) Space
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s2 == null || s2.length() == 0 || s1.length() > s2.length()) return false;

        int m = s1.length(), n = s2.length();
        int hashS1 = 0, hashS2 = 0;
        int prime = 101;

        //Calculate the 1st window hash value
        for(int i = 0; i < m; i++) {
            hashS1 = (hashS1 + s1.charAt(i)) % prime;
            hashS2 = (hashS2 + s2.charAt(i)) % prime;
        }

        for(int i = 0; i <= n-m; i++) {
            if(hashS1 == hashS2) {
                if(isAnagram(s1, s2.substring(i, i + m))) return true;
            }

            //Update hash value for the new window in S2
            if(i < n - m) {
                hashS2 = (hashS2 - s2.charAt(i) + s2.charAt(i + m)) % prime;

                //if hashS2 < 0, make it positive
                if(hashS2 < 0) {
                    hashS2 += prime;
                }
            }
        }

        return false;
    }

    /**
     * O(m + n) Time complexity
     * O(1) Space
     * @param s1
     * @param s2
     * @return
     */
    private boolean isAnagram(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
        int[] hash = new int[26];
        for(int i = 0; i < s1.length(); i++)
            hash[s1.charAt(i) - 'a']++;

        for(int i = 0; i < s2.length(); i++) {
            if(--hash[s2.charAt(i) - 'a'] < 0) return false;
        }

        return true;
    }
}

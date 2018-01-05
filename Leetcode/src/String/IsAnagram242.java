package String;

import java.util.Arrays;

/**
 * Created by Tien on 1/5/2018.
 *
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class IsAnagram242 {

    /**
     * O(n) Time Complexity - O(1) Space
     * @param s
     * @param t
     * @return
     */
    boolean isAnagram1(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] hash = new int[256];
        for(int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        for(int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]--;
            if(hash[t.charAt(i)] < 0)
                return false;
        }

        return true;
    }

    /**
     * O(nlogn) Time complexity (merge sort or any O(nlogn) sorting algorithm, and O(n^2) for any O(n^2) sorting algorithm)
     * O(n) Space
     * @param s
     * @param t
     * @return
     */
    boolean isAnagram2(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);

        for(int i = 0; i < s.length(); i++) {
            if(cs[i] != ct[i])
                return false;
        }

        return true;
    }
}

package Hashtable;

import java.util.HashMap;

/**
 * Created by Tien on 4/5/2018.
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class IsomorphicStrings205 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        HashMap<Character, Character> hm = new HashMap<>();
        for(int i = 0; i < sc.length; i++) {
            if(hm.containsKey(sc[i])) {
                if(!hm.get(sc[i]).equals(tc[i])) return false;
            } else if(hm.containsValue(tc[i])) {
                return false;
            } else {
                hm.put(sc[i], tc[i]);
            }
        }
        return true;
    }

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for(int i = 0; i < s.length(); i++) {
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) return false;
            map1[s.charAt(i)] = i+1;
            map2[t.charAt(i)] = i+1;
        }
        return true;
    }
}

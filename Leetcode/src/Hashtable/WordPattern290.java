package Hashtable;

import java.util.HashMap;

/**
 * Created by Tien on 4/5/2018.
 *
 * https://leetcode.com/problems/word-pattern/description/
 *
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern290 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        char[] charPattern = pattern.toCharArray();
        String[] stringStr = str.split("\\s+");
        if(charPattern.length != stringStr.length) return false;

        HashMap<Character, String> hashMap = new HashMap<>();
        for(int i = 0; i < charPattern.length; i++) {
            if(hashMap.containsKey(charPattern[i])) {
                if(!hashMap.get(charPattern[i]).equals(stringStr[i])) return false;
            } else if(hashMap.containsValue(stringStr[i])) {
                return false;
            } else {
                hashMap.put(charPattern[i], stringStr[i]);
            }
        }
        return true;
    }
}

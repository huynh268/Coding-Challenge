package String;

import java.util.HashMap;

/**
 * Created by Tien on 5/6/2018.
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:
 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring76 {

    /**
     * Sliding Window - Two Pointers
     *
     * Time complexity: O(n+m)
     * Space complexity: O(n+m)
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow1(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(s == null || t == null || n == 0 || m == 0 || n < m) return "";

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : ct) hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

        int min = n+1;
        int minL = 0;
        int l = 0;
        int count = 0;

        for(int r = 0; r < n; r++) {
            if(hashMap.containsKey(cs[r])) {
                hashMap.put(cs[r], hashMap.get(cs[r]) - 1);
                if(hashMap.get(cs[r]) >= 0){
                    count++;
                }

                while(count == m) {
                    if(min > r - l + 1) {
                        min = r - l + 1;
                        minL = l;
                    }

                    if(hashMap.containsKey(cs[l])) {
                        hashMap.put(cs[l], hashMap.get(cs[l]) + 1);
                        if(hashMap.get(cs[l]) > 0) count--;
                    }

                    l++;
                }
            }
        }

        if(min > n) return "";

        return s.substring(minL, minL + min);
    }

}

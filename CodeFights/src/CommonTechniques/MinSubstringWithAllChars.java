package CommonTechniques;

/**
 * Created by Tien on 11/26/2017.
 * You have two strings, s and t. The string t contains only unique elements. Find and return the minimum consecutive substring of s that contains all of the elements from t.

 It's guaranteed that the answer exists. If there are several answers, return the one which starts from the smallest index.

 Example

 For s = "adobecodebanc" and t = "abc", the output should be
 minSubstringWithAllChars(s, t) = "banc".
 */
public class MinSubstringWithAllChars {
    public static String minSubstringWithAllChars(String s, String t) {
        int n = s.length();
        int m = t.length();

        //Check if s or t is either empty
        if(n == 0) return "";
        if(m == 0 || m > n) return "";

        //Create hashtable to store number of each character in s and t
        int[] hash_s = new int[26];
        int[] hash_t = new int[26];

        //Count number of each character in t
        for(int i = 0; i < m; i++) {
            hash_t[t.charAt(i)-'a']++;
        }


        int     count = 0, //Used to check if the substring contains all characters in t
                start = 0,  //start index of the substring that contains all characters in t
                start_index = 0,//start index of the substring that contains all characters in t and
                                //substring has the shortest length
                minLen = Integer.MAX_VALUE; //Used to check if the substring has the shortest length

        for(int i = 0; i < n; i++) {

            //Count number of each character in s
            hash_s[s.charAt(i)-'a']++;

            //Check if character in s matched character in t, then update count
            if(hash_t[s.charAt(i)-'a'] != 0 && hash_s[s.charAt(i)-'a'] <= hash_t[s.charAt(i)-'a'])
                count++;

            //If substring of s contains all character in t
            if(count == m) {

                //If character at index 'start' is not in t
                //Or character at index of s appears more times than it does in t
                //Then remove it and update 'start'
                while(hash_s[s.charAt(start)-'a'] > hash_t[s.charAt(start)-'a'] || hash_t[s.charAt(start)-'a'] == 0) {
                    if(hash_s[s.charAt(start)-'a'] > hash_t[s.charAt(start)-'a'])
                        hash_s[s.charAt(start)-'a']--;
                    start++;
                }

                //Check if the current substring has the shortest length
                //If it does, then update minLen and starting index of the substring
                int tmpLen = i - start + 1;
                if(tmpLen < minLen) {
                    minLen = tmpLen;
                    start_index = start;
                }
            }
        }

        return s.substring(start_index, start_index + minLen);
    }
}

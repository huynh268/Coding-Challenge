package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 8/19/2018.
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 Return a list of all uncommon words.
 You may return the list in any order.



 Example 1:
 Input: A = "this apple is sweet", B = "this apple is sour"
 Output: ["sweet","sour"]
 Example 2:

 Input: A = "apple apple", B = "banana"
 Output: ["banana"]


 Note:

 0 <= A.length <= 200
 0 <= B.length <= 200
 A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsFromTwoSentences884 {

    /**
     * Time complexity: O(n+m)
     * Space complexity: O(n+m)
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
        List<String> list = new ArrayList<>();
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");

        HashMap<String, Integer> hs = new HashMap<>();
        for(String s: sa) hs.put(s, hs.getOrDefault(s, 0)+1);
        for(String s: sb) hs.put(s, hs.getOrDefault(s, 0)+1);
        for(String key: hs.keySet()){
            if(hs.get(key) < 2) list.add(key);
        }
        String[] ans = new String[list.size()];
        int i = 0;
        for(String s: list) {
            ans[i++] = s;
        }
        return ans;
    }
}

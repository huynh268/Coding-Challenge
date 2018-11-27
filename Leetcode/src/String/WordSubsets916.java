package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 10/5/2018.
 *
 *
 *
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 Now say a word a from A is universal if for every b in B, b is a subset of a.
 Return a list of all universal words in A.  You can return the words in any order.



 Example 1:
 Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 Output: ["facebook","google","leetcode"]

 Example 2:
 Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 Output: ["apple","google","leetcode"]

 Example 3:
 Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 Output: ["facebook","google"]

 Example 4:
 Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 Output: ["google","leetcode"]

 Example 5:
 Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 Output: ["facebook","leetcode"]


 Note:
 1 <= A.length, B.length <= 10000
 1 <= A[i].length, B[i].length <= 10
 A[i] and B[i] consist only of lowercase letters.
 All words in A[i] are unique: there isn't i != j with A[i] == A[j].

 */
public class WordSubsets916 {

    /**
     * Time complexity: O(A+B) - A = total length of all words in A, B = total length of all words in B
     * Space complexity: O(A+B)
     * @param A
     * @param B
     * @return
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();

        int[] count = new int[26];
        for(String b : B) {
            int[] cb = count(b);
            for(int i = 0; i < 26; i++) {
                if(count[i] < cb[i]) count[i] = cb[i];
            }
        }

        search: for(String a : A) {
            int[] ca = count(a);
            for(int i = 0; i < 26; i++) {
                if(ca[i] < count[i]) continue search;
            }
            ans.add(a);
        }

        return ans;
    }

    public int[] count(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        return count;
    }
}

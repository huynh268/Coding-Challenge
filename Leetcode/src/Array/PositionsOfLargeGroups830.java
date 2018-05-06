package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tien on 5/5/2018.
 *
 *
 *
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 The final answer should be in lexicographic order.



 Example 1:
 Input: "abbxxxxzzy"
 Output: [[3,6]]
 Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.

 Example 2:
 Input: "abc"
 Output: []
 Explanation: We have "a","b" and "c" but no large group.

 Example 3:
 Input: "abcdddeeeeaabbbcd"
 Output: [[3,5],[6,9],[12,14]]

 Note:  1 <= S.length <= 1000
 */
public class PositionsOfLargeGroups830 {

    /**
     * Two Pointers
     * O(n) Time complexity
     * O(n) Space
     * @param S
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if(S.length() <= 2) return ans;
        int s = 0, e = 1;

        while(e <= S.length()) {
            if(e < S.length() && S.charAt(e) == S.charAt(s)) {
                e++;
            } else {
                if(e - s >= 3) {
                    ans.add(Arrays.asList(s, e - 1));
                }
                s = e;
                e++;
            }
        }

        return ans;
    }
}

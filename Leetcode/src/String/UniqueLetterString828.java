package String;

import java.util.Arrays;

/**
 * Created by Tien on 5/5/2018.
 *
 *
 *
 * A character is unique in string S if it occurs exactly once in it.
 For example, in string S = "LETTER", the only unique characters are "L" and "R".
 Let's define UNIQ(S) as the number of unique characters in string S.

 For example, UNIQ("LETTER") =  2.

 Given a string S, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
 If there are two or more equal substrings at different positions in S, we consider them different.
 Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.



 Example 1:
 Input: "ABC"
 Output: 10
 Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
 Evey substring is composed with only unique letters.
 Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10

 Example 2:
 Input: "ABA"
 Output: 8
 Explanation: The same as example 1, except uni("ABA") = 1.


 Note: 0 <= S.length <= 10000.
 */
public class UniqueLetterString828 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param S
     * @return
     */
    public int uniqueLetterString(String S) {
        int ans = 0;
        int n = S.length();

        //indexes stores indexes of the last 2 occurences of char c
        int[][] indexes = new int[26][2];

        for(int[] i : indexes) {
            Arrays.fill(i, -1);
        }

        for(int i = 0; i < n; i++) {
            int c = S.charAt(i) - 'A';

            //for any char c, there are (indexes[c][1] - indexes[c][0]) ways to start and (i - indexes[c][1]) ways to end the substring that contains only one char c
            //therefore, there are (i - indexes[c][1]) * (indexes[c][1] - indexes[c][0]) substrings
            ans += (i - indexes[c][1]) * (indexes[c][1] - indexes[c][0]);

            //update indexes of c
            indexes[c][0] = indexes[c][c];
            indexes[c][1] = i;
        }

        //since previous loop runs from 0 to n-1, loop again the indexes array and count for n
        for(int i = 0; i < 26; i++) {
            ans += (n - indexes[i][1]) * (indexes[i][1] - indexes[i][0]);
        }

        return ans;
    }
}

package Array;

/**
 * Created by Tien on 4/21/2018.
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

 Example 1:
 Input: S = "loveleetcode", C = 'e'
 Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


 Note:
 S string length is in [1, 10000].
 C is a single character, and guaranteed to be in string S.
 All letters in S and C are lowercase.
 */
public class ShortestDistanceToACharacter821 {

    /**
     * O(n^2) Time complexity
     * O(n) Space
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar1(String S, char C) {
        int n = S.length();
        int[] distances = new int[n];
        for(int i = 0; i < n; i++) {
            if(S.charAt(i) == C) {
                distances[i] = 0;
            } else {
                int minDistance = Integer.MAX_VALUE;
                for(int j = 0; j < n; j++) {
                    if(S.charAt(j) == C && minDistance > Math.abs(j-i)) {
                        minDistance = Math.abs(j-i);
                    }
                }
                distances[i] = minDistance;
            }
        }
        return distances;
    }

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param S
     * @param C
     * @return
     */
    public int[] shortestToChar2(String S, char C) {
        int n = S.length();
        int[] distances = new int[n];
        int pre = -10001;

        for(int i = 0; i < n; i++) {
            if(S.charAt(i) == C) pre = i;
            distances[i] = i - pre;
        }

        pre = 10001;
        for(int i = n-1; i >=0; i--) {
            if(S.charAt(i) == C) pre = i;
            distances[i] = Math.min(distances[i], pre - i);
        }

        return distances;
    }
}

package String;

import java.util.Arrays;

/**
 * Created by Tien on 9/2/2018.
 *
 * https://leetcode.com/problems/orderly-queue/description/
 *
 * A string S of lowercase letters is given.  Then, we may make any number of moves.
 In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.
 Return the lexicographically smallest string we could have after any number of moves.


 Example 1:
 Input: S = "cba", K = 1
 Output: "acb"
 Explanation:
 In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".

 Example 2:
 Input: S = "baaca", K = 3
 Output: "aaabc"
 Explanation:
 In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".


 Note:
 1 <= K <= S.length <= 1000
 S consists of lowercase letters only.
 */
public class OrderlyQueue899 {

    /**
     * Time complexity: O(nlogn)
     * Space complexity: O(nlogn)
     * @param S
     * @param K
     * @return
     */
    public String orderlyQueue(String S, int K) {

        //If K == 1, find all rotations of S and compare them to find the lexicographically smallest string
        if(K == 1) {
            String ans = S;

            for(int i = 1; i < S.length(); i++) {
                //Rotate S
                //S = baaca, i = 2 => s = acaba
                String s = S.substring(i) + S.substring(0, i);

                //Compare in lexicographical order
                if(s.compareTo(ans) < 0) ans = s;
            }

            return ans;

        //If K > 1, every char in S can move to any position
        //S = 123456, K = 2, then 1 and 2 can be swapped: 134562 -> 345621 -> 213456
        //Or 3 and 4: 345612 -> 356124 -> 561243 -> 124356
        } else {
            char[] s = S.toCharArray();
            Arrays.sort(s);

            return new String(s);
        }
    }
}

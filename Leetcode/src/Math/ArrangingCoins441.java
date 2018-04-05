package Math;

/**
 * Created by Tien on 4/4/2018.
 *
 * https://leetcode.com/problems/arranging-coins/description/
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 Given n, find the total number of full staircase rows that can be formed.
 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:
 n = 5
 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤
 Because the 3rd row is incomplete, we return 2.

 Example 2:
 n = 8
 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤
 Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins441 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        if(n <= 0) return n;
        for(int i = 1; ; i++) {
            n -= i;
            if(n < 0) return i-1;
        }
    }

    public int arrangeCoins(int n) {

    }
}

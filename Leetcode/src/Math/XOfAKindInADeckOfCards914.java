package Math;

/**
 * Created by Tien on 10/4/2018.
 *
 *
 *
 * In a deck of cards, each card has an integer written on it.
 Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

 Each group has exactly X cards.
 All the cards in each group have the same integer.


 Example 1:
 Input: [1,2,3,4,4,3,2,1]
 Output: true
 Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]

 Example 2:
 Input: [1,1,1,2,2,2,3,3]
 Output: false
 Explanation: No possible partition.

 Example 3:
 Input: [1]
 Output: false
 Explanation: No possible partition.

 Example 4:
 Input: [1,1]
 Output: true
 Explanation: Possible partition [1,1]

 Example 5:
 Input: [1,1,2,2,2,2]
 Output: true
 Explanation: Possible partition [1,1],[2,2],[2,2]

 Note:
 1 <= deck.length <= 10000
 0 <= deck[i] < 10000
 */
public class XOfAKindInADeckOfCards914 {

    /**
     * Time complexity: O(nlog^2(N))
     * Space complexity: O(n)
     *
     * @param deck
     * @return
     */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[100000];
        for(int i : deck) count[i]++;

        int gcd = 0;
        for(int i : count) gcd = gcd(gcd, i);

        return gcd > 1;
    }

    public int gcd(int a, int b) {
        return b == 0? a : gcd(b, a%b);
    }
}

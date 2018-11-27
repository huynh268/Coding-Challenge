package Hashtable;

/**
 * Created by Tien on 8/26/2018.
 *
 * https://leetcode.com/problems/bulls-and-cows/description/
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is.
 * Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both
 * digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.
 Please note that both secret number and friend's guess may contain duplicate digits.

 Example 1:
 Input: secret = "1807", guess = "7810"
 Output: "1A3B"
 Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.

 Example 2:
 Input: secret = "1123", guess = "0111"
 Output: "1A1B"
 Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.

 Note: You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsAndCows299 {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1);
     *
     * @param s
     * @param g
     * @return
     */
    public String getHint(String s, String g) {
        int[] cs = new int[10];
        int[] cg = new int[10];

        for(int i = 0; i < s.length(); i++) cs[s.charAt(i) - '0']++;
        for(int i = 0; i < g.length(); i++) cg[g.charAt(i) - '0']++;

        int matches = 0;
        for(int i = 0; i < cs.length; i++) {
            matches += Math.min(cs[i], cg[i]);
        }

        int bulls = 0;
        for(int i = 0; i < s.length(); i++) {
            bulls += s.charAt(i) == g.charAt(i) ? 1 : 0;
        }

        int cows = matches - bulls;

        return bulls + "A" + cows + "B";
    }
}

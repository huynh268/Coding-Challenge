package String;

/**
 * Created by Tien on 6/11/2018.
 *
 * https://leetcode.com/problems/shifting-letters/description/
 *
 * We have a string S of lowercase letters, and an integer array shifts.
 Call the shift of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
 For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
 Now for each shifts[i] = x, we want to shift the first i+1 letters of S, x times.
 Return the final string after all such shifts to S are applied.

 Example 1:
 Input: S = "abc", shifts = [3,5,9]
 Output: "rpl"
 Explanation:
 We start with "abc".
 After shifting the first 1 letters of S by 3, we have "dbc".
 After shifting the first 2 letters of S by 5, we have "igc".
 After shifting the first 3 letters of S by 9, we have "rpl", the answer.

 Note:
 1 <= S.length = shifts.length <= 20000
 0 <= shifts[i] <= 10 ^ 9
 */
public class ShiftingLetters848 {

    /**
     * O(n) Time complexity
     * O(N) Space
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters1(String S, int[] shifts) {
        int sum = 0;
        for(int i : shifts) {
            sum = (sum + i)%26;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            sb.append((char)((S.charAt(i) - 'a' + sum)%26 + 97));
            sum = Math.floorMod(sum - shifts[i], 26);
        }

        return sb.toString();
    }

    /**
     * O(n) Time complexity
     * O(N) Space
     * @param S
     * @param shifts
     * @return
     */
    public String shiftingLetters2(String S, int[] shifts) {
        for(int i = shifts.length-2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i+1])%26;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < S.length(); i++) {
            sb.append((char)((S.charAt(i) - 'a' + shifts[i])%26 + 'a'));
        }

        return sb.toString();
    }
}

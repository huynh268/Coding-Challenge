package String;

/**
 * Created by Tien on 5/2/2018.
 *
 * https://leetcode.com/problems/count-and-say/description/
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:
 Input: 1
 Output: "1"

 Example 2:
 Input: 4
 Output: "1211"

 */
public class CountAndSay38 {

    /**
     * Time complexity: O(2^n)
     * Space complexity: O(2^n)
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String ans = "1";
        while(n > 0) {
            ans = helper(ans);
            n--;
        }
        return ans;
    }

    public String helper(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            int j = 1;
            while(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                i++;
                j++;
            }
            sb.append(j);
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

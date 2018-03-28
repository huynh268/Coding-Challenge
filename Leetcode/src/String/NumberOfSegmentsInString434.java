package String;

/**
 * Created by Tien on 3/27/2018.
 *
 * https://leetcode.com/problems/number-of-segments-in-a-string/description/
 *
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5
 */
public class NumberOfSegmentsInString434 {

    /**
     * O(n) Time complexity
     * O(n) Space
     * @param s
     * @return
     */
    public int countSegments1(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        String[] segments = s.split("\\s+");
        return segments.length;
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param s
     * @return
     */
    public int countSegments2(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') count++;
        }
        return count;
    }
}

package String;

/**
 * Created by Tien on 2/12/2018.
 *
 * https://leetcode.com/problems/student-attendance-record-i/description/
 *
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.

 Example 1:
 Input: "PPALLP"
 Output: True

 Example 2:
 Input: "PPALLL"
 Output: False
 */
public class StudentAttendanceRecordI551 {

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param s
     * @return
     */
    boolean checkRecord1(String s) {
        int countA = 0;
        int countL = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'A') countA++;
            if(s.charAt(i) == 'L') {
                if(i > 0 && s.charAt(i) == 'L') countL++;
                else countL = 1;
            }

            if(countA > 1 || countL > 2) return false;
        }

        return true;
    }

    /**
     * Regex
     * O(n) Time complexity
     * O(1) Space
     * @param s
     * @return
     */
    boolean checkRecord2(String s) {
        return !s.matches(".*A.*A.* | .*LLL.*");
    }

    /**
     * Index of
     * O(n*m) = O(3n) = O(n) Time complexity, where m = 3 (length of "LLL", which is constant)
     * O(1) Space
     * @param s
     * @return
     */
    boolean checkRecord3(String s) {
        return s.indexOf("LLL") == -1 && s.indexOf("A") == s.lastIndexOf("A");
    }

    boolean checkRecord4(String s) {
        return !s.contains("LLL") && s.indexOf("A") == s.lastIndexOf("A");
    }
}

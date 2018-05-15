package Math;

/**
 * Created by Tien on 5/14/2018.
 *
 * https://leetcode.com/problems/valid-square/description/
 *
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.

 The coordinate (x,y) of a point is represented by an integer array with two integers.

 Example:
 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 Output: True

 Note:
 All the input integers are in the range [-10000, 10000].
 A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 Input points have no order.

 */
public class ValidSquare593 {

    /**
     * O(1) Time complexity
     * O(1) Space
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @return
     */
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isEqualDistance(p1, p2, p3, p4) ||
                isEqualDistance(p1,p3, p2, p4) ||
                isEqualDistance(p1, p4, p2, p3);
    }

    public int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public boolean isEqualDistance(int[] p1, int[] p2, int[] p3, int[] p4) {
        return  distance(p1, p2) > 0 &&
                distance(p1, p2) == distance(p1, p4) &&
                distance(p1, p3) == distance(p2, p4) &&
                distance(p1, p2) == distance(p3, p4);
    }
}

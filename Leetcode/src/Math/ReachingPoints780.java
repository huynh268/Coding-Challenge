package Math;

/**
 * Created by Tien on 9/7/2018.
 *
 * https://leetcode.com/problems/reaching-points/description/
 *
 * A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).
 Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

 Examples:

 Input: sx = 1, sy = 1, tx = 3, ty = 5
 Output: True
 Explanation:
 One series of moves that transforms the starting point to the target is:
 (1, 1) -> (1, 2)
 (1, 2) -> (3, 2)
 (3, 2) -> (3, 5)

 Input: sx = 1, sy = 1, tx = 2, ty = 2
 Output: False

 Input: sx = 1, sy = 1, tx = 1, ty = 1
 Output: True

 Note:
 sx, sy, tx, ty will all be integers in the range [1, 10^9].
 */
public class ReachingPoints780 {

    /**
     * Top-down - Time Limit Exceeded
     *
     * Time complexity: T(n) = T(n-1) + T(n-1) + C = O(2^n)
     * Space complexity: O(2^n)
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty) {
            return true;
        } else if(sx > tx || sy > ty) {
            return false;
        } else {
            return reachingPoints1(sx, sx + sy, tx, ty) || reachingPoints1(sx + sy, sy, tx, ty);
        }
    }

    /**
     * Bottom-up
     *
     * Time complexity: O(log(max(tx, ty))
     * Space complexity: O(1)
     *
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @return
     */
    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        while(sx < tx && sy < ty) {
            if(tx < ty) {
                ty %= tx;
            } else {
                tx %= ty;
            }
        }

        return sx == tx && (ty - sy)%sx == 0 || sy == ty && (tx - sx)%sy == 0;
    }
}

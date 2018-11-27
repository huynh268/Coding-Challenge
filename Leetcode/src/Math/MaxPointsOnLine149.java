package Math;

import java.util.HashMap;

/**
 * Created by Tien on 9/15/2018.
 *
 * https://leetcode.com/problems/max-points-on-a-line/description/
 *
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

 Example 1:

 Input: [[1,1],[2,2],[3,3]]
 Output: 3
 Explanation:
 ^
 |
 |        o
 |     o
 |  o
 +------------->
 0  1  2  3  4
 Example 2:

 Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 Output: 4
 Explanation:
 ^
 |
 |  o
 |     o        o
 |        o
 |  o        o
 +------------------->
 0  1  2  3  4  5  6
 */
public class MaxPointsOnLine149 {

    class Point {
        int x;
        int y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     *
     * @param points
     * @return
     */
    public int maxPoints(Point[] points) {
        if(points.length <=  2) return points.length;

        int max = 0;

        for(int i = 0; i < points.length-1; i++) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            int sameP = 0; //count same point
            int sameV = 1; //count points on the same vertical line
            int maxP = 0;  //count points that are on the same line with points[i]

            for(int j = i+1; j < points.length; j++) {
                if(points[i].x == points[j].x && points[i].y == points[j].y) { //points[i] and points[j] are the same
                    sameP++;
                } else if (points[i].y == points[j].y) { //points[i] and points[j] are on the same vertical line
                    sameV++;
                } else {

                    //get slope of the line that points[i] and points[j] lie on
                    String slope = slope(points[i], points[j]);
                    hashMap.put(slope, hashMap.getOrDefault(slope, 1) + 1);
                    maxP = Math.max(maxP, hashMap.get(slope));
                }
            }
            maxP = sameP + Math.max(maxP, sameV);
            max = Math.max(max, maxP);
        }

        return max;
    }

    public String slope(Point p1, Point p2) {
        int px = p1.x - p2.x;
        int py = p1.y - p2.y;
        int gcd = gcd(px, py);
        return py/gcd + "/" + px/gcd;
    }

    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}

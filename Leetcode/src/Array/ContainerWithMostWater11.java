package Array;

/**
 * Created by Tien on 9/6/2018.
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.


 Example:
 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49
 */
public class ContainerWithMostWater11 {

    /**
     * Two pointers
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int max = 0;
        int l = 0, r = height.length-1;

        while(l < r) {
            int area = (r-l)*Math.min(height[l], height[r]);
            max = Math.max(max, area);

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }

    /**
     * Brute force
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int max = 0;

        for(int i = 1; i < height.length; i++) {
            for(int j = 0; j < i; j++) {
                int area = (i-j)*Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }

        return max;
    }
}

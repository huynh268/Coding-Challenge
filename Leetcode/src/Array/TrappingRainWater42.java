package Array;

import java.util.Stack;

/**
 * Created by Tien on 9/10/2018.
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 * Example:
 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrappingRainWater42 {

    /**
     * Stack
     *
     * Time complexity: O(n) - each element in height is visited at most twice
     * Space complexity: O(n)
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        if(n < 2) return ans;

        Stack<Integer> stack = new Stack<>();
        int max = height[0];
        for(int i = 0; i < n; i++) {
            if(height[i] == 0 && stack.isEmpty()) {
                continue;
            } else if(height[i] < max) {
                stack.push(height[i]);
            } else {
                while(!stack.isEmpty()) {
                    ans += max - stack.pop();
                }
                max = height[i];
                stack.push(height[i]);
            }
        }

        max = 0;
        while(!stack.isEmpty()) {
            if(max > stack.peek()) {
                ans += max - stack.pop();
            } else {
                max = stack.pop();
            }
        }

        return ans;
    }



}

package HeapStackQueue;

import java.util.Stack;

/**
 * Created by Tien on 9/14/2018.
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * Example:
 Input: [2,1,5,6,2,3]
 Output: 10
 */
public class LargestRectangleInHistogram87 {

    /**
     * Time complexity: O(n) - Each element in heights is visited twice
     * Space complexity: O(n)
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= n; i++) {
            int height = i == n ? 0 : heights[i];
            if(stack.isEmpty() || height >= heights[i]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }

        return max;
    }
}

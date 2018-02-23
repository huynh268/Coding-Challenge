package Array;

import java.util.Stack;

/**
 * Created by Tien on 2/22/2018.
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.

 For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

 Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperatures739 {

    /**
     * Brute force
     * O(n^2) Time complexity
     * O(n) Space
     * @param temperatures
     * @return
     */
    int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == n-1) ans[i] = 0;
            for(int j = i+1; j < n; j++) {
                if(j == n-1 && temperatures[i] >= temperatures[j]) ans[i] = 0;
                if(temperatures[i] >= temperatures[j]) continue;
                else {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * Stack
     * O(n) Time complexity
     * O(n) Space
     * @param temperatures
     * @return
     */
    int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}

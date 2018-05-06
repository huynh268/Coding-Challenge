package Math;

/**
 * Created by Tien on 5/5/2018.
 *
 * https://leetcode.com/problems/consecutive-numbers-sum/description/
 *
 * Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

 Example 1:
 Input: 5
 Output: 2
 Explanation: 5 = 5 = 2 + 3

 Example 2:
 Input: 9
 Output: 3
 Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4

 Example 3:
 Input: 15
 Output: 4
 Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

 Note: 1 <= N <= 10 ^ 9.
 */
public class ConsecutiveNumbersSum829 {

    /**
     * O(sqrt(N)) Time complexity
     * O(1) Space
     *
     * N = a + (a+1) + .. + (a + n)
     *   = na + n(n+1)/2 (Gauss Sum Formula)
     * Therefore, a = [N - n(n+1)/2]/n and a must be an integer
     *
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int count = 0;

        for(int i = 1; i*(i+1) <= 2*N; i++) {
            double j = (2.0*N - i*(i+1)) / (2*i);

            //Check if j is an integer
            if(j == (int)j) count++;
        }

        return count;
    }
}

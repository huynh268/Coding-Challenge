package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Tien on 3/10/2018.
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
 * For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
 * And we defined a friend circle is a group of students who are direct or indirect friends.

 Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1,
 then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

 Example 1:
 Input:
 [[1,1,0],
 [1,1,0],
 [0,0,1]]
 Output: 2
 Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 The 2nd student himself is in a friend circle. So return 2.
 Example 2:
 Input:
 [[1,1,0],
 [1,1,1],
 [0,1,1]]
 Output: 1
 Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 Note:
 N is in range [1,200].
 M[i][i] = 1 for all students.
 If M[i][j] = 1, then M[j][i] = 1.

 */
public class FriendCircles547 {

    /**
     * DFS
     * O(n^2) Time complexity
     * O(1) Space
     * @param M
     * @return
     */
    public int findCircleNum1(int[][] M) {
        int ans = 0;
        for(int i = 0; i < M.length; i++) {
            if(M[i][i] == 1) {
                ans++;
                dfs(M, i);
                M[i][i] = 0;
            }
        }
        return ans;
    }

    private void dfs(int[][] M, int i) {
        for(int j = 0; j < M.length; j++) {
            if(M[j][j] == 1 && M[i][j] == 1) {
                M[j][j] = 0;
                dfs(M, j);
            }
        }
    }

    /**
     * Iterative - Stack
     * O(n^2) Time complexity
     * O(n) Space
     * @param M
     * @return
     */
    public int findCircleNum2(int[][] M) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < M.length; i++) {
            if(M[i][i] == 1) {
                ans++;
                stack.push(i);

                while(!stack.isEmpty()) {
                    int row = stack.pop();
                    for(int j = 0; j < M.length; j++) {
                        if(M[j][j] == 1 && M[row][j] == 1) {
                            M[j][j] = 0;
                            stack.push(j);
                        }
                    }
                }

                M[i][i] = 0;
            }
        }

        return ans;
    }

    /**
     * Iterative - Queue
     * O(n^2) Time complexity
     * O(n) Space
     * @param M
     * @return
     */
    public int findCircleNum3(int[][] M) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                ans++;
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int row = queue.poll();
                    for (int j = 0; j < M.length; j++) {
                        if (M[j][j] == 1 && M[row][j] == 1) {
                            M[j][j] = 0;
                            queue.offer(j);
                        }
                    }
                }

                M[i][i] = 0;
            }
        }

        return ans;
    }
}

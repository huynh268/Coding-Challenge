package Array;

import java.util.HashMap;

/**
 * Created by Tien on 2/20/2018.
 *
 * https://leetcode.com/problems/4sum-ii/description/
 *
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

 To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

 Example:

 Input:
 A = [ 1, 2]
 B = [-2,-1]
 C = [-1, 2]
 D = [ 0, 2]

 Output:
 2

 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII454 {

    /**
     * O(n^2) Time complexity
     * O(n^2) Space complexity
     */
    int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                hashMap.put(A[i] + B[j], hashMap.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        int count = 0;
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                if(hashMap.containsKey(-(C[i] + D[j])))
                    count += hashMap.get(-(C[i] + D[j]));
            }
        }
        return count;
    }
}

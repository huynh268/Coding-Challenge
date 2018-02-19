package Math;

/**
 * Created by Tien on 1/11/2018.
 *
 *https://leetcode.com/problems/rotate-function/description/
 *
 * Given an array of integers A and let n to be its length.

 Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:

 F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].

 Calculate the maximum value of F(0), F(1), ..., F(n-1).

 Note:
 n is guaranteed to be less than 105.

 Example:

 A = [4, 3, 2, 6]

 F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 */
public class RotateFunction396 {

    /**
     * Matrix multiplication f*A where  f is 1x(n-1) matrix (1 row, n-1 columns)
     *                                  A is (n-1)x1 matrix (n-1 rows, 1 column)
     *
     * We have:
     * f(0) = [0,1,2,3,...,n-1]*A[n]
     * f(1) = [n-1,0,1,2,...,n-2]*A[n]
     *
     * Therefore,
     * f(k)        = [k  ,k+1,k+2,..,n-2,n-1,  0,  1,...,k-2,k-1]*A
     * f(k+1)      = [k+1,k+2,k+3,..,n-1,0  ,  1,  2,...,k-1,k  ]*A
     *
     * Subtract:
     * f(k+1)-f(k) = [  1,  1,  1,..,  1,  1, -n + 1,  1,...,  1,  1]*A
     *             = A[0] + A[1] + A[2] + ... - n*A[n-1-k] + A[n-1-k] + ... + A[n-2] + A[n-1]
     *             = A[0] + A[1] + ... + A[n-1] - n*A[n-1-k]
     *
     * Then we have:
     * f(k+1)-f(k) = sum - n*A[n-1-k], where sum = Sum(A's elements)
     *
     * f(k+1) = f(k) + sum - n*A[n-1-k]
     *
     * f(1) = f(0) + sum - n*A[n-1-0] = f(0) + sum - n*A[n-1]
     * f(2) = f(1) + sum - n*A[n-1-1] = f(2) + sum - n*A[n-2]
     * @param A
     * @return
     */
    int maxRotateFunction(int[] A) {
        int n = A.length;
        int sum = 0;
        int f = 0;

        for(int i = 0; i < n; i++) {
            sum += A[i];
            f += i*A[i];
        }

        int max = f;
        for(int i = n-1; i >= 0; i--) {
            f = f + sum - A[i]*n;
            max = max < f? f : max;
        }

        return max;
    }
}

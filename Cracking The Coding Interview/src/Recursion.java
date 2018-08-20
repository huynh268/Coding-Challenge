/**
 * Created by Tien on 8/19/2018.
 */
public class Recursion {

    /**
     * 8.1
     *
     * Recursion
     *
     * Time complexity: T(n) = T(n-1) + T(n-2) = O(2^n)
     * Space complexity: O(n)
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo1(int n) {
        if(n <= 1) {
            return n;
        } else {
            return fibo1(n-1) + fibo1(n-2);
        }
    }

    /**
     * 8.1
     *
     * Dynamic programming
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo2(int n) {
        if(n <= 1) return n;

        int[] f = new int[n+2];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    /**
     * 8.1
     *
     * Dynamic programming with optimized space
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Write a method to generate the nth Fibonacci number.
     * @param n
     * @return
     */
    public int fibo3(int n) {
        if(n <= 1) return n;
        int f0 = 0, f1 = 1, f;
        for(int i = 2; i <= n; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f1;
    }


}

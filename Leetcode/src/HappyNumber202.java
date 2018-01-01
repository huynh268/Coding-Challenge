/**
 * Created by Tien on 12/31/2017.
 *
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 */
public class HappyNumber202 {

    /**
     * Cheating solution
     * Only 2 numbers < 10 are happy numbers (1,7)
     * Recursively calculate new n until it is less than 10
     * If it is not equal 1 or 7, it is not a happy number.
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if(n == 1 || n == 7)
            return true;
        if(n < 10)
            return false;
        int a = n;
        n = 0;
        while(a > 0) {
            n += sqr(a%10);
            a/=10;
        }

        return isHappy(n);
    }

    /**
     * Find the square of a number
     * @param i
     * @return i*i
     */
    private int sqr(int i) {
        return i*i;
    }
}

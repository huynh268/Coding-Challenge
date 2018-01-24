import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 1/23/2018.
 *
 *https://leetcode.com/problems/self-dividing-numbers/description/
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 Also, a self-dividing number is not allowed to contain the digit zero.
 Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

 Example 1:
 Input:
 left = 1, right = 22
 Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 Note:

 The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class SelfDividingNumbers728 {

    /**
     * N = right - left
     * R = right, the largest number
     * O(NlogR) Time complexity
     * O(N) Space
     * @param left
     * @param right
     * @return
     */
    List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i = left; i <= right; i++) {
            if(check(i)) ans.add(i);
        }
        return ans;
    }

    /**
     * O(logN) Time complexity
     * O(1) Space
     * @param n
     * @return
     */
    boolean check(int n) {
        int m = n;
        while(m > 0) {
            int i = m%10;
            m /= 10;
            if(i == 0 || n%i != 0) return false;
        }
        return true;
    }
}

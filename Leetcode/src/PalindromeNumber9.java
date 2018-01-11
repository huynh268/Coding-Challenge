/**
 * Created by Tien on 1/10/2018.
 *
 *https://leetcode.com/problems/palindrome-number/description/
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber9 {
    boolean isPalindrome(int x) {
        if(x < 0 || x%10 == 0 && x != 0)
            return false;

        int n = 0;
        while (x > n) {
            n = n*10 + x%10;
            x /= 10;
        }

        return x == n || x == n/10;
    }
}

package String;

/**
 * Created by Tien on 1/19/2018.
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome409 {

    /**
     * Greedy choice
     * O(n) Time complexity
     * O(n) Space
     * @param s
     * @return
     */
    int longestPalindrome(String s) {
        char[] c = new char[256];

        for(int i = 0; i < s.length(); i++)
            c[s.charAt(i)]++; //count s.charAt(i)

        int ans = 0;
        for(int i : c) {
            //If i is even, then it can make i/2 pairs. Else (i-1)/2 pairs
            //Therefore length of palindrome string is expanded i if i is even and i-1 if i is od.
            ans += i%2 == 0? i : i-1;

            //If i is odd, there are (i-1) pairs and 1 char left
            //If ans is even, then the palindrome doesn't have a center letter yet
            //And if i is odd, we can use the char which can't pair up to make it at center letter.
            if(ans%2 == 0 && i%2 == 1) ans++;
        }

        return ans;
    }
}

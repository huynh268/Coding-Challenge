package Array;

import java.util.Arrays;

/**
 * Created by Tien on 1/19/2018.
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.

 Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

 Examples:
 Input:
 letters = ["c", "f", "j"]
 target = "a"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "c"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "d"
 Output: "f"

 Input:
 letters = ["c", "f", "j"]
 target = "g"
 Output: "j"

 Input:
 letters = ["c", "f", "j"]
 target = "j"
 Output: "c"

 Input:
 letters = ["c", "f", "j"]
 target = "k"
 Output: "c"

 Note:
 - letters has a length in range [2, 10000].
 - letters consists of lowercase letters, and contains at least 2 unique letters.
 - target is a lowercase letter.
 */
public class FindSmallestLetterGreaterThanTarget744 {

    /**
     * Linear scan
     * O(n) Time complexity
     * O(1) Space
     * @param letters
     * @param target
     * @return
     */
    char nextGreatestLetter1(char[] letters, char target) {
        for(char c : letters) {
            if(c > target) return c;
        }
        return letters[0];
    }

    /**
     * O(n) Time complexity
     * O(1) Space
     * @param letters
     * @param target
     * @return
     */
    char nextGreatestLetter2(char[] letters, char target) {
        boolean[] check = new boolean[26];
        for(char c : letters)
            check[c - 'a'] = true;

        while(target < 'z'){
            target++;
            if(check[target - 'a']) return target;
        }

        return letters[0];
    }

    /**
     * Binary search
     * O(logn) Time complexity
     * O(1) Space
     * @param letters
     * @param target
     * @return
     */
    char nextGreatestLetter3(char[] letters, char target) {
        char c = target == 'z' ? 'a' : (char)(target + 1);
        int i = Arrays.binarySearch(letters, c);

        if(i >= 0) return letters[i];
        else {
            i = Math.abs(i+1);
            return letters[i%letters.length];
        }
    }
}

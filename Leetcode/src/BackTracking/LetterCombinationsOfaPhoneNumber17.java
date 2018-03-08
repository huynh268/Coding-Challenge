package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tien on 3/7/2018.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsOfaPhoneNumber17 {

    private static final String[] keys = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * Backtracking
     * O(a^n) Time complexity - a = number of letters that each key can generate
     * O(a^n) Space
     * @param digits
     * @return
     */
    List<String> letterCombinations1(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        backtracking(digits, "", 0, ans);
        return ans;
    }

    void backtracking(String digits, String prefix, int key, List<String> ans) {
        if(key >= digits.length()) {
            ans.add(prefix);
            return;
        }
        String letters = keys[digits.charAt(key) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            backtracking(digits, prefix + letters.charAt(i), key + 1, ans);
        }
    }

    /**
     * Using LinkedList - FIFO
     * O(a^n) Time comeplity
     * O(a^n) Space
     * @param digits
     * @return
     */
    List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return ans;
        ans.add("");
        for(int i = 0; i < digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            while(ans.peek().length() == i) {
                String tmp = ans.remove();
                for(char c : keys[key].toCharArray()) {
                    ans.add(tmp + c);
                }
            }
        }

        return ans;
    }
}

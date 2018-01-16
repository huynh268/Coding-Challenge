package String;

/**
 * Created by Tien on 1/15/2018.
 *
 * https://leetcode.com/problems/detect-capital/description/
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:
 Input: "USA"
 Output: True

 Example 2:
 Input: "FlaG"
 Output: False
 Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital520 {
    boolean detectCapitalUse1(String word) {
        return word.matches("[A-Z]+ | [a-z]+ | [A-Z][a-z]+");
    }

    boolean detectCapitalUse2(String word) {
        return word.matches("[A-Z]* | .[a-z]*");
    }

    boolean detectCapitalUse3(String word) {
        int n = word.length();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') count++;
        }

        return count == 0 || count == n || count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
    }

    boolean detectCapitalUse4(String word) {
        if(word.equals(word.toUpperCase())) return true;
        for(int i = 1; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
        }

        return true;
    }
}

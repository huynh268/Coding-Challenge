import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Tien on 11/10/2017.
 */

/**
 A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and digits,
 such that the given arithmetic equation consisting of letters holds true when the letters are converted to digits.

 You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and digits, solution.
 The array crypt will contain three non-empty strings that follow the structure: [word1, word2, word3], which should be interpreted
 as the word1 + word2 = word3 cryptarithm.

 If crypt, when it is decoded by replacing all of the letters in the cryptarithm with digits using the mapping in solution,
 becomes a valid arithmetic equation containing no numbers with leading zeroes, the answer is true.
 If it does not become a valid arithmetic solution, the answer is false.

 Example
 For crypt = ["SEND", "MORE", "MONEY"] and
 solution = [['O', '0'],
 ['M', '1'],
 ['Y', '2'],
 ['E', '5'],
 ['N', '6'],
 ['D', '7'],
 ['R', '8'],
 ['S', '9']]
 the output should be
 isCryptSolution(crypt, solution) = true.
 When you decrypt "SEND", "MORE", and "MONEY" using the mapping given in crypt, you get 9567 + 1085 = 10652 which is correct and a valid arithmetic equation.

 For crypt = ["TEN", "TWO", "ONE"] and
 solution = [['O', '1'],
 ['T', '0'],
 ['W', '9'],
 ['E', '5'],
 ['N', '4']]
 the output should be
 isCryptSolution(crypt, solution) = false.
 Even though 054 + 091 = 145, 054 and 091 both contain leading zeroes, meaning that this is not a valid solution.
 */
public class IsCryptSolution {

    //O(n) Time complexity where n = solution.length - O(1) Space
    public static boolean isCryptSolution1(String[] crypt, char[][] solution) {
        for(char[] c : solution) {
            for(int i = 0; i < crypt.length; i++) {
                crypt[i] = crypt[i].replace(c[0], c[1]);
            }
            System.out.println(Arrays.toString(crypt));
        }

        for(int i = 0; i < crypt.length; i++) {
            if(crypt.length > 1 && crypt[i].startsWith("0"))
                return false;
        }

        return Long.parseLong(crypt[0]) + Long.parseLong(crypt[1]) == Long.parseLong(crypt[2]);
    }

    //O(m*n) where m = crypt.length and n = solution.length - O(n) space
    public static boolean isCryptSolution2(String[] crypt, char[][] solution) {
        HashMap<Character,Character> h = new HashMap<>();
        for(int i = 0; i < solution.length; i++) {
            h.put(solution[i][0], solution[i][1]);
        }

        String[] v = new String[3];
        int j = 0;
        for(String s : crypt) {
            String st = "";
            if(h.get(s.charAt(0)) == '0' && s.length() > 1)
                return false;
            for(int i = 0; i < s.length(); i++){
                st += h.get(s.charAt(i));
                System.out.println("String  " + s +" = "+st);
            }
            v[j++] = st;
        }

        return Long.parseLong(v[0]) + Long.parseLong(v[1]) == Long.parseLong(v[2]);
    }

    public static void main(String[] args) {

        String[] crypt = {"SEND", "MORE", "MONEY"};
        char[][] solution ={{'O', '0'},
                            {'M', '1'},
                            {'Y', '2'},
                            {'E', '5'},
                            {'N', '6'},
                            {'D', '7'},
                            {'R', '8'},
                            {'S', '9'}};
        long startTime1 = System.currentTimeMillis();
        System.out.println(isCryptSolution2(crypt,solution));
        long endTime1   = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println(totalTime1);

        System.out.println("________________________________");
        long startTime2 = System.currentTimeMillis();
        System.out.println(isCryptSolution1(crypt,solution));
        long endTime2   = System.currentTimeMillis();
        long totalTime2 = endTime2 - startTime2;
        System.out.println(totalTime2);
    }
}

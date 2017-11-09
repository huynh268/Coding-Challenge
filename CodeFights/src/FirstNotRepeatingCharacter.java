/**
 * Created by Tien on 11/8/2017.
 */
public class FirstNotRepeatingCharacter {

    /**
     Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.

     Example

     For s = "abacabad", the output should be
     firstNotRepeatingCharacter(s) = 'c'.

     There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

     For s = "abacabaabacaba", the output should be
     firstNotRepeatingCharacter(s) = '_'.

     There are no characters in this string that do not repeat.
     */

    //
    public static char firstNotRepeatingCharacter(String s) {
        int[][] count = new int[2][26];

        for(int i = 0 ; i < s.length(); i++){
            if(count[1][s.charAt(i)-'a'] == 0) {
                count[0][s.charAt(i)-'a'] = i; //1st appreance index
            }
            count[1][s.charAt(i) - 'a']++; //count number of appreances
        }

        int index = -1, min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++){
            if(count[1][i] == 1 && min > count[0][i]) {
                min = count[0][i];
                index = i;
            }
        }

        //Print storage matrix
        /*
        for(int i = 0; i < 2; i ++){
            System.out.println();
            for(int j = 0; j < 26; j++){
                System.out.printf("%3d",count[i][j]);
            }
        }
        System.out.println();
        */

        return index == -1 ? '_' : (char)(index + 97);
    }

    public static void main(String[] args) {
        System.out.println("String s = \"abacabad\": " + firstNotRepeatingCharacter("abacabad"));
        System.out.println("String s = \"abacabaabacaba\": " + firstNotRepeatingCharacter("abacabaabacaba"));
        System.out.println("String s = \"a\": " + firstNotRepeatingCharacter("a"));
        System.out.println("String s = \"ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof\": " + firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
        System.out.println("String s = \"xdnxxlvupzuwgigeqjggosgljuhliybkjpibyatofcjbfxwtalc\": " + firstNotRepeatingCharacter("xdnxxlvupzuwgigeqjggosgljuhliybkjpibyatofcjbfxwtalc"));
    }
}

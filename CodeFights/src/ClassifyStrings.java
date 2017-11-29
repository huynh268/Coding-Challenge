/**
 * Created by Tien on 11/28/2017.
 * The string can also contain the character ?, which can be replaced by either a vowel or a consonant. This means that the string "?aa" can be bad if ? is a vowel or good if it is a consonant. This kind of string is categorized as mixed.

 Implement a function that takes a string s and returns its category: good, bad, or mixed.

 Example

 For s = "aeu", the output should be
 classifyStrings(s) = "bad";

 For s = "a?u", the output should be
 classifyStrings(s) = "mixed";

 For s = "aba", the output should be
 classifyStrings(s) = "good".
 */
public class ClassifyStrings {

    //Does not work on "aa?bbbb" or "bbbb?aa"
    public static String classifyStrings(String s) {
        int n = s.length();

        if(n <= 2) return "good";

        int[][] m = new int[3][n];

        int c = 0;
        if(s.charAt(0) == '?') c = 1;
        m[0][0] = c == 1 ? -1 : "aeiou".indexOf(s.charAt(0)) < 0 ? 1 : 0; // 1 = consonant, 0 = vowel, -1 = ?
        m[1][0] = c == 1 ? -1 : 1; //1 = good, 0 = bad, -1 = mixed
        m[2][0] = c == 1 ? 0 : 1; //count

        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == '?') c = 1;

            if(m[1][i-1] == -1){
                m[0][i] = s.charAt(i) == '?' ? -1 : "aeiou".indexOf(s.charAt(i)) < 0 ? 1 : 0;
                m[1][i] = s.charAt(i) == '?' ? -1 : 1;
                m[2][i] = s.charAt(i) == '?' ? 0 : 1;
            }
            else {
                int temp = s.charAt(i) == '?' ? -1 : ("aeiou".indexOf(s.charAt(i)) < 0 ? 1 : 0);
                if(m[0][i-1] != temp  ) {
                    m[0][i] = s.charAt(i) == '?' ? -1 : ("aeiou".indexOf(s.charAt(i)) < 0 ? 1 : 0);
                    m[1][i] = s.charAt(i) == '?' ? -1 : 1;
                    m[2][i] = s.charAt(i) == '?' ? 0 : 1;
                } else {
                    m[0][i] = s.charAt(i) == '?' ? -1 : "aeiou".indexOf(s.charAt(i)) < 0 ? 1 : 0;
                    if(s.charAt(i) == '?') m[1][i] = -1;
                    else{
                        if(m[0][i] == 1){
                            m[1][i] = m[2][i-1] == 4 ? 0 : 1;
                        } else{
                            m[1][i] = m[2][i-1] == 2 ? 0 : 1;
                        }
                    }
                    m[2][i] = m[2][i-1] + 1;
                }
            }

            if(m[1][i] == 0) return "bad";
        }
        return c == 1? "mixed": "good";
    }

}

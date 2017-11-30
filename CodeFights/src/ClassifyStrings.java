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

    //Naive solution
    //Does not work on "aa?bbb?aa" - "bad"
    public static String classifyStrings1(String s) {
        int n = s.length();

        if(n <= 2) return "good";

        int[][] m = new int[3][n];

        int c = 0;
        if(s.charAt(0) == '?') c = 1;
        m[0][0] = c == 1 ? -1 : check(s.charAt(0))? 1 : 0; // 1 = consonant, 0 = vowel, -1 = ?
        m[1][0] = c == 1 ? -1 : 1; //1 = good, 0 = bad, -1 = mixed
        m[2][0] = c == 1 ? 0 : 1; //count

        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == '?') c = 1;

            if(m[0][i-1] == -1){
                m[0][i] = s.charAt(i) == '?' ? -1 : (check(s.charAt(i)) ? 1 : 0);
                m[1][i] = s.charAt(i) == '?' ? -1 : 1;
                m[2][i] = s.charAt(i) == '?' ? 0 : 1;
            }
            else {
                int temp = s.charAt(i) == '?' ? -1 : (check(s.charAt(i)) ? 1 : 0);

                if(m[0][i-1] != temp  ) {

                    m[0][i] = s.charAt(i) == '?' ? -1 : (check(s.charAt(i)) ? 1 : 0);
                    m[1][i] = s.charAt(i) == '?' ? -1 : 1;
                    m[2][i] = s.charAt(i) == '?' ? 0 : 1;
                } else {
                    m[0][i] = s.charAt(i) == '?' ? -1 : check(s.charAt(i)) ? 1 : 0;
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

        if(n >= 7){
            int x = s.indexOf('?',1);
            while(x >= 0 && x < n-2) {
                if(x<n-4 && m[0][x-1] == 0 && m[2][x-1] == 2 && m[0][x+1] == 1 && m[2][x+4] == 4){
                    return "bad";
                }
                if(m[0][x-1] == 1 && m[2][x-1] == 4 && m[0][x+1] == 0 && m[2][x+2] == 2){
                    return "bad";
                }
                x = s.indexOf('?',x+1);
            }
        }

        return c == 1? "mixed": "good";
    }
    private static boolean check(char c){
        return "aeiou".indexOf(c) < 0;
    }

    //Recursive solution -- Credit k_lee
    public static String classifyStrings2(String s) {
        //System.out.println(s.replaceAll("[aeiou]","a"));
        //System.out.println(s.replaceAll("[a-z&&[^aeiou]]","b"));
        if(s.matches("(.*[aeiou]{3}.*)|(.*[^aeiou?]{5}.*)"))
            return "bad";
        if(!s.contains("?"))
            return "good";

        String a = classifyStrings2(s.replaceFirst("\\?","a"));
        String b = classifyStrings2(s.replaceFirst("\\?","b"));
        System.out.println("a: "+ a+", b: "+ b);
        return a.equals(b) ? a : "mixed";
    }

    //Regex only
    ////Does not work on "aa?bbb?aa", "aa?bbbb -> "bad"
    public static String classifyStrings3(String s) {
        if(s.matches("(.*[aeiou]{3}.*)|(.*[^aeiou?]{5}.*)"))
            return "bad";
        if(s.matches("(.*[aeiuo?]{3})|(.*[^aeiou]{5}.*)"))
            return "mixed";
        return "good";

    }
}

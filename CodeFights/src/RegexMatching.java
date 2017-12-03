import java.util.regex.Pattern;

/**
 * Created by Tien on 12/2/2017.
 */
public class RegexMatching {

    //Using built-in methods
    boolean regexMatching1(String pattern, String test) {
        String p = pattern;
        if(pattern.charAt(0) == '^' && pattern.charAt(pattern.length()-1) == '$'){
            if(pattern.length() - 2 != test.length()) return false;
            p = p.substring(1,pattern.length()-1);
            return p.equals(test);
        }
        if(pattern.charAt(0) == '^'){
            p = pattern.substring(1);
            String temp = test.substring(0, pattern.length()-1);
            return p.equals(temp);
        }
        if(pattern.charAt(pattern.length()-1) == '$'){
            p = pattern.substring(0,pattern.length()-1);
            String temp = test.substring(test.length()-pattern.length()+1, test.length());
            return p.equals(temp);
        }

        return test.contains(p);
    }

    //Using built-in methods
    boolean regexMatching2(String pattern, String test) {
        return Pattern.compile(pattern).matcher(test).find();
    }

    //Using built-in methods
    boolean regexMatching3(String pattern, String test) {
        if (pattern.startsWith("^"))
            return test.startsWith(pattern.substring(1));
        if (pattern.lastIndexOf("$") == pattern.length()-1){
            return test.endsWith(pattern.substring(0,pattern.length()-1));
        }

        return test.contains(pattern);
    }
}

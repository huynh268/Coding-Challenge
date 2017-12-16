package Strings;

import java.util.stream.Collectors;

/**
 * Created by Tien on 12/16/2017.
 *
 * You have been given a string s, which is supposed to be a sentence.
 * However, someone forgot to put spaces between the different words,
 * and for some reason they capitalized the first letter of every word.
 * Return the sentence after making the following amendments:

 Put a single space between the words.
 Convert the uppercase letters to lowercase.
 Example

 For s = "CodefightsIsAwesome", the output should be
 amendTheSentence(s) = "codefights is awesome";
 For s = "Hello", the output should be
 amendTheSentence(s) = "hello".
 */
public class AmendTheSentence {

    String amendTheSentence1(String s) {
        String[] ss = s.split("(?=[A-Z])");
        String sss = "";
        for(int i =0; i<ss.length; i++)
            sss+= i!=ss.length-1? ss[i].toLowerCase()+" ": ss[i].toLowerCase() ;
        return sss;
    }

    String amendTheSentence2(String s) {
        String[] ss = s.split("(?=[A-Z])");

        return String.join(" ",ss).toLowerCase();
    }
    //Credit: casual_b
    String amendTheSentence3(String s) {
        return s.chars()
                .mapToObj(i -> (char)i)
                .map(c -> Character.isUpperCase(c) ? " " + Character.toLowerCase(c) : "" + c)
                .collect(Collectors.joining(""))
                .trim();

    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 11/30/2017.
 * Given an array of words and a length l, format the text such that each line
 * has exactly l characters and is fully justified on both the left and the right.
 * Words should be packed in a greedy approach; that is, pack as many words as possible in each line.
 * Add extra spaces when necessary so that each line has exactly l characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text and lines with one word only, the words should be left
 * justified with no extra space inserted between them.

 Example

 For
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 and l = 16, the output should be

 textJustification(words, l) = ["This    is    an",
                                "example  of text",
                                "justification.  "]
 */
public class TextJustification {
    
    public static String[] textJustification(String[] words, int l) {
        int n = words.length;

        //Store current words with total len + additional spaces <= l
        List<String> list = new ArrayList<>();
        //Result
        List<String> result = new ArrayList<>();

        int len = 0;
        for(int i = 0; i < n; i++) {
            if(len + words[i].length() <= l){
                list.add(words[i]);
                len = len + words[i].length() + 1; //add words[i] and a space
                if(i == n-1){ //if there is no word left
                    result.add(helper2(list, l));
                }
            } else {
                result.add(helper1(list, l));
                list.clear();
                list.add(words[i]);
                len = words[i].length() + 1;
                if(i == n-1){
                    result.add(helper2(list, l));
                }
            }
        }
        return result.toArray(new String[0]);

    }

    //Create string with words in the list and additional spaces
    //String length = l
    static String helper1(List<String> list, int l) {
        String r = "";
        String[] st = list.toArray(new String[0]);
        int len = 0;
        for(int i = 0; i < st.length; i++)
            len += st[i].length();

        int spaceLen = l - len;
        int j = 0;
        while(spaceLen > 0) {
            if(j >= st.length-1)
                j = 0;
            st[j] += " ";
            j++;
            spaceLen--;
        }

        for(int i = 0; i < st.length; i++)
            r = r + st[i];
        return r;
    }

    //Create string - the last line of text and lines with one word only
    static String helper2(List<String> a, int l) {
        String r = "";
        for(int i = 0; i < a.size(); i++){
            if(i == a.size() - 1)
                r += a.get(i);
            else
                r += a.get(i) + " ";
        }
        int rlen = r.length();
        for(int i = 1; i <= l-rlen; i++){
            r += " ";
        }
        return r;
    }

}

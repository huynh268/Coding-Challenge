package HashTables;

import java.util.HashMap;

/**
 * Created by Tien on 12/5/2017.
 * Given an array strings, determine whether it follows the sequence given in the patterns array.
 * In other words, there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j]
 * or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

 Example

 For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
 areFollowingPatterns(strings, patterns) = true;

 For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
 areFollowingPatterns(strings, patterns) = false.
 */
public class AreFollowingPatterns {

    boolean areFollowingPatterns(String[] strings, String[] patterns) {
        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();

        for(int i = 0; i < strings.length; i++) {
            if(!hm1.containsKey(strings[i])) {
                hm1.put(strings[i], patterns[i]);
            } else if(!hm1.get(strings[i]).equals(patterns[i]))
                return false;

            if(!hm2.containsKey(patterns[i])) {
                hm2.put(patterns[i], strings[i]);
            } else if(!hm2.get(patterns[i]).equals(strings[i]))
                return false;
        }

        return true;
    }

}

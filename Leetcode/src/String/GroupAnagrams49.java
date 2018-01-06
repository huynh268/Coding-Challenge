package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tien on 1/5/2018.
 *
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 https://leetcode.com/articles/group-anagrams/
 */
public class GroupAnagrams49 {

    List<List<String>> groupAnagram(String[] strings) {
        if(strings == null || strings.length == 0)
            return new ArrayList<>();

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for(String s :  strings) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String tmpKey = new String(c);

            if(!hashMap.containsKey(tmpKey))
                hashMap.put(tmpKey, new ArrayList<>());
            hashMap.get(tmpKey).add(s);
        }

        return new ArrayList<>(hashMap.values());
    }
}

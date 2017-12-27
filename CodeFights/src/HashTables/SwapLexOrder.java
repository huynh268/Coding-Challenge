package HashTables;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tien on 12/6/2017.
 * Given a string str and array of pairs that indicates which indices in the string can be swapped, return the lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.

 Example

 For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
 swapLexOrder(str, pairs) = "dbca".

 By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicographically largest string in this list is "dbca".
 */
public class SwapLexOrder {

    //Naive Solution - Does not work on big pairs.length
    String swapLexOrder(String str, int[][] pairs) {
        if(pairs.length == 0) return str;

        HashSet<String> hs = new HashSet<>();
        hs.add(str);
        for(int i = 0; i < pairs.length; i++) {
            List<String> l = new ArrayList<>(hs);

            for(String s:l) {
                for(int[] p : pairs)
                    hs.add(swap(s, p));
            }
        }

        List<String> res = new ArrayList<>(hs);
        Collections.sort(res);
        return res.get(res.size()-1);
    }

    String swap(String s, int[] pair) {
        if(pair[0] == pair[1]) return s;
        char[] c = s.toCharArray();

        char temp = s.charAt(pair[0]-1);
        c[pair[0]-1] = c[pair[1]-1];
        c[pair[1]-1] = temp;

        return new String(c);
    }


    //DFS
    //1 - Find connected components
    //2 - Sort each component
    void dfs(int letter, List<Integer> component, boolean[] visited, int[][] graph) {
        visited[letter] = true;
        component.add(letter);

        for(int neighbor = 0; neighbor < graph[letter].length; neighbor++) {
            if(graph[letter][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, component, visited, graph);
            }
        }
    }
}

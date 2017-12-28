package HashTables;

import java.util.*;

/**
 * Created by Tien on 12/6/2017.
 * Given a string str and array of pairs that indicates which indices in the string can be swapped,
 * return the lexicographically largest string that results from doing the allowed swaps. You can swap indices any number of times.

 Example

 For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
 swapLexOrder(str, pairs) = "dbca".

 By swapping the given indices, you get the strings: "cbda", "cbad", "dbac", "dbca". The lexicographically largest string in this list is "dbca".
 */
public class SwapLexOrder {

    /**
     * Naive Solution - Does not work on big pairs.length
     * @param str - given string
     * @param pairs - each pair in pairs indicates which indices in the string can be swapped
     * @return the lexicographically largest string that results from doing the allowed swaps
     */
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


    /*
    DFS
    1 - Find connected components
    2 - Sort each component list
    3 - Generate new string with order of component lists
     */

    /**
     * Using Array to implement undirected graph - Adjacency Matrix
     * @param str - given string
     * @param pairs - each pair in pairs indicates which indices in the string can be swapped
     * @return the lexicographically largest string that results from doing the allowed swaps
     */
    String swapLexOrder2(String str, int[][] pairs) {
        int n = str.length();
        char[] chars = str.toCharArray();

        int[][] adjacencyMatrix = new int[n][n];
        for(int i = 0; i < pairs.length; i++) {
            adjacencyMatrix[pairs[i][0] - 1][pairs[i][1] - 1] = 1;
            adjacencyMatrix[pairs[i][1] - 1][pairs[i][0] - 1] = 1;
        }

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs2(i, component, visited, adjacencyMatrix);
                sort(chars, component);
            }
        }

        return chars.toString();
    }
    void dfs2(int letter, List<Integer> component, boolean[] visited, int[][] adjacencyMatrix) {
        visited[letter] = true;
        component.add(letter);

        for(int neighbor = 0; neighbor < adjacencyMatrix[letter].length; neighbor++) {
            if(adjacencyMatrix[letter][neighbor] == 1 && !visited[neighbor]) {
                dfs2(neighbor, component, visited, adjacencyMatrix);
            }
        }
    }

    /**
     * Using Hashtable to implement undirected graph - Adjacency List
     * @param str - given string
     * @param pairs - each pair in pairs indicates which indices in the string can be swapped
     * @return the lexicographically largest string that results from doing the allowed swaps
     */
    String swapLexOrder3(String str, int[][] pairs) {
        int n = str.length();
        char[] chars = str.toCharArray();

        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for(int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<Integer>());
        }

        for(int[] pair : pairs) {
            adjacencyList.get(pair[0]-1).add(pair[1]-1);
            adjacencyList.get(pair[1]-1).add(pair[0]-1);
        }

        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                dfs3(i, component, visited, adjacencyList);
                sort(chars, component);
            }
        }

        return new String(chars);
    }
    void dfs3(int letter, List<Integer> component, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjacencyList) {
        visited.add(letter);
        component.add(letter);

        for(int neighbor : adjacencyList.get(letter)) {
            if(!visited.contains(neighbor)) {
                dfs3(neighbor, component, visited, adjacencyList);
            }
        }
    }

    /**
     * Sort component list by corresponding characters from given string
     * @param chars - chars array of given string
     * @param component - list of indexes of chars in given string that can be swapped position
     */
    void sort(char[] chars, List<Integer> component) {
        Collections.sort(component);

        List<Character> componentChars = new ArrayList<>();

        for(int i : component) {
            componentChars.add(chars[i]);
        }

        Collections.sort(componentChars, Collections.reverseOrder());

        int index = 0;
        for(int i : component) {
            chars[i] = componentChars.get(index);
            index++;
        }
    }
}

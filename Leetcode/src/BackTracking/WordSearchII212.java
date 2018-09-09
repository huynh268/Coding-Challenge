package BackTracking;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tien on 3/16/2018.
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearchII212 {

    public class TrieNode {
        TrieNode[] nodes;
        String word = "";

        public TrieNode() {
            this.nodes = new TrieNode[26];
        }

        public boolean containsChar(char c) {
            return nodes[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            nodes[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return nodes[c - 'a'];
        }

        public void setWord(String word) {
            this.word = word;
        }
    }

    public class Trie {
        TrieNode root;
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String[] words) {
            for(String word : words) {
                insert(word);
            }
        }

        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.containsChar(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setWord(word);
        }

        public boolean search(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.containsChar(c)) return false;
                node = node.get(c);
            }
            return node.word.equals(word);
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char c : prefix.toCharArray()) {
                if(!node.containsChar(c)) return false;
                node = node.get(c);
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> ans = new HashSet<>();
        Trie trie = new Trie();
        trie.insert(words);

        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, "", trie, ans, i, j, visited);
            }
        }

        return new ArrayList<String>(ans);
    }

    public void dfs(char[][] board, String s, Trie trie, HashSet<String> ans, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j]) {
            return;
        } else {
            s += board[i][j];

            if(!trie.startsWith(s)) return;
            if(trie.search(s)) ans.add(s);

            visited[i][j] = true;
            dfs(board, s, trie, ans, i-1, j, visited);
            dfs(board, s, trie, ans, i+1, j, visited);
            dfs(board, s, trie, ans, i, j-1, visited);
            dfs(board, s, trie, ans, i, j+1, visited);
            visited[i][j] = false;
        }
    }
}

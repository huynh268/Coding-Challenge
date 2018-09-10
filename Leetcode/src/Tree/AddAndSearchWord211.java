package Tree;

/**
 * Created by Tien on 9/9/2018.
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * Design a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 Example:
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true


 Note:
 You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord211 {

    class WordDictionary {

        public class TrieNode {
            private TrieNode[] childrens;
            private String word;

            public TrieNode() {
                this.childrens = new TrieNode[26];
                this.word = "";
            }
            public boolean containsChar(char c) {
                return childrens[c - 'a'] != null;
            }

            public void put(char c, TrieNode child) {
                childrens[c - 'a'] = child;
            }

            public TrieNode get(char c) {
                return childrens[c - 'a'];
            }

            public void setWord(String word) {
                this.word = word;
            }
        }

        private TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            this.root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.containsChar(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setWord(word);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return match(word, root, 0);
        }

        /**
         * Time complexity: O(n) - n is the length of word
         * space complexity: O(n)
         * @param word
         * @param node
         * @param i
         * @return
         */
        public boolean match(String word, TrieNode node, int i) {
            if(i == word.length()) return !node.word.equals("");

            char c = word.charAt(i);
            if(c != '.') {
                return node.containsChar(c) && match(word, node.get(c), i+1);
            } else {
                for(TrieNode child : node.childrens) {
                    if(child != null && match(word, child, i+1)) return true;
                }
            }

            return false;
        }

    }

}

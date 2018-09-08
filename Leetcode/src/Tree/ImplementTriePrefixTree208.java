package Tree;

/**
 * Created by Tien on 9/7/2018.
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 Example:
 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTriePrefixTree208 {

    /** TrieNode class*/
    public class TrieNode {
        private TrieNode[] nextNodes;
        private boolean isLeaf;

        public TrieNode() {
            //Since all inputs are consist of lowercase letters a-z, there are 26 characters
            this.nextNodes = new TrieNode[26];
        }

        //Check if char c is in this node
        public boolean containsChar(char c) {
            return nextNodes[c - 'a'] != null;
        }

        public void put(char c, TrieNode node) {
            nextNodes[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return nextNodes[c - 'a'];
        }

        public void setLeaf(){
            isLeaf = true;
        }
    }

    /** Initialize your data structure here. */
    public class Trie {
        private TrieNode root;

        //Constructor
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         *
         * Time comeplexity: O(n), n is word.length
         * Space complexity: O(n)
         *
         * @param word
         */
        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.containsChar(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setLeaf();
        }

        /**
         * Returns if the word is in the trie.
         *
         * Time complexity: O(n)
         * Space complexity: O(1)
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                if(!node.containsChar(c)) return false;
                node = node.get(c);
            }

            return node.isLeaf;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         *
         * Time complexity: O(n)
         * Space complexity: O(1)
         *
         * @param prefix
         * @return
         */
        public boolean startWith(String prefix){
            TrieNode node = root;
            for(char c : prefix.toCharArray()) {
                if(!node.containsChar(c)) return false;
                node = node.get(c);
            }
            return true;
        }
    }
}

package cn.itwx.leetcode201_210;

public class Leetcode208 {

    class Trie {
        Trie[] tries;
        boolean isWord;
        // char ch;

        /** Initialize your data structure here. */
        public Trie() {
            tries = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            char[] chs = word.toCharArray();
            for(char c: chs){
                int index = c - 'a';
                if(node.tries[index] == null) node.tries[index] = new Trie();
                //  node.tries[c - 'a'].ch = c;
                node = node.tries[c - 'a'];
            }
            node.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = this;
            char[] chs = word.toCharArray();
            for(char c: chs){
                int index = c - 'a';
                if(node.tries[index] != null){
                    node = node.tries[index];
                }else return false;
            }
            if(!node.isWord) return false;
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = this;
            char[] chs = prefix.toCharArray();
            for(char c: chs){
                int index = c - 'a';
                if(node.tries[index] != null){
                    node = node.tries[index];
                }else return false;
            }
            return true;
        }
    }
}

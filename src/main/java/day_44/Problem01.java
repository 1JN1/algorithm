package day_44;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/9
 * @description 实现Trie(前缀树)
 **/
public class Problem01 {


    class Trie {


        private TrieNode root;

        private class TrieNode {
            private boolean isEnd;
            private TrieNode[] children;

            public TrieNode() {
                isEnd = false;
                children = new TrieNode[26];
            }
        }

        public Trie() {

            root = new TrieNode();

        }

        public void insert(String word) {

            int length = word.length();
            TrieNode current = root;

            for (int i = 0; i < length; i++) {

                int ch = word.charAt(i) - 'a';
                if (current.children[ch] == null) {
                    current.children[ch] = new TrieNode();
                }
                current = current.children[ch];

            }

            current.isEnd = true;

        }

        public boolean search(String word) {

            int length = word.length();
            TrieNode current = root;

            for (int i = 0; i < length; i++) {

                int ch = word.charAt(i) - 'a';
                if (current.children[ch] == null) {
                    return false;
                }

                current = current.children[ch];
            }

            return current.isEnd;
        }

        public boolean startsWith(String prefix) {

            int length = prefix.length();

            TrieNode current = root;
            for (int i = 0; i < length; i++) {
                int ch = prefix.charAt(i) - 'a';
                if (current.children[ch] == null) {
                    return false;
                }
                current = current.children[ch];
            }

            return true;
        }
    }


    @Test
    public void test() {


        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }


}

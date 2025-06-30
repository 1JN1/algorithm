package day_44;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/9
 * @description 添加与搜索单词-数据结构设计
 **/
public class Problem03 {

    @Test
    public void test() {

        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad."));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.m"));

    }

    class WordDictionary {

        private WordDictionary[] words;
        private boolean isEnd;

        public WordDictionary() {

            words = new WordDictionary[26];
            isEnd = false;

        }

        public void addWord(String word) {

            int length = word.length();
            WordDictionary wordDictionary = this;

            for (int i = 0; i < length; i++) {

                int ch = word.charAt(i) - 'a';
                if (wordDictionary.words[ch] == null) {
                    wordDictionary.words[ch] = new WordDictionary();
                }
                wordDictionary = wordDictionary.words[ch];

            }

            wordDictionary.isEnd = true;

        }

        public boolean search(String word) {

            return searchHelper(word, this, 0, word.length() - 1);
        }

        private boolean searchHelper(String word, WordDictionary wordDictionary, int begin, int end) {

            for (int i = begin; i <= end; i++) {

                char ch = word.charAt(i);
                if ('.' == ch) {
                    for (int j = 0; j < 26; j++) {
                        if (wordDictionary.words[j] != null && searchHelper(word, wordDictionary.words[j], begin + 1, end)) {
                            return true;
                        }
                    }
                    return false;
                } else {

                    int chIdx = ch - 'a';
                    if (wordDictionary.words[chIdx] == null) {
                        return false;
                    }

                    return searchHelper(word, wordDictionary.words[chIdx], begin + 1, end);
                }

            }

            return wordDictionary.isEnd;
        }
    }

}

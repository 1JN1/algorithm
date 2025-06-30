package day_52;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/17
 * @description 单词规律
 **/
public class Problem03 {

    @Test
    public void test() {

        String pattern = "abba";
        String s = "dog dog dog dog";

        System.out.println(wordPattern(pattern, s));

    }

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        int length = pattern.length();

        if (words.length != length) {
            return false;
        }

        Map<Character, String> p2s = new HashMap<>();
        Map<String, Character> s2p = new HashMap<>();

        for (int i = 0; i < length; i++) {

            char c = pattern.charAt(i);
            if (p2s.containsKey(c) && !p2s.get(c).equals(words[i])) {
                return false;
            }

            if (s2p.containsKey(words[i]) && !s2p.get(words[i]).equals(c)) {
                return false;
            }

            p2s.put(c, words[i]);
            s2p.put(words[i], c);
        }

        return true;
    }

}

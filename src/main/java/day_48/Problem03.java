package day_48;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description 有效的字母异同词
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(isAnagram("a", "ab"));

    }

    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        if (map1.size() != map2.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {

            char ch = t.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            if (map.get(ch) < 0) {
                return false;
            }
        }

        return true;
    }


}

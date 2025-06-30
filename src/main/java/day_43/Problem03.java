package day_43;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/8
 * @description 同构字符串
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(isIsomorphic("badc", "baba"));

    }

    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> s2t = new HashMap<>(s.length());
        Map<Character, Character> t2s = new HashMap<>(t.length());

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {

            if (!s2t.containsKey(s.charAt(i)) && !t2s.containsKey(t.charAt(i))) {
                s2t.put(s.charAt(i), t.charAt(i));
                t2s.put(t.charAt(i), s.charAt(i));
            } else {

                if (s2t.get(s.charAt(i)) == null || s2t.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }

            }

        }

        return true;
    }

}

package day_48;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description 移位字符串分组
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));

    }

    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> g = new HashMap<>();
        for (String s : strings) {
            char[] t = s.toCharArray();
            int diff = t[0] - 'a';
            for (int i = 0; i < t.length; ++i) {
                t[i] = (char) (t[i] - diff);
                if (t[i] < 'a') {
                    t[i] += 26;
                }
            }

            String key = String.valueOf(t);

            // g.computeIfAbsent(key, k -> new ArrayList<>()).add(s);

            List<String> list = g.getOrDefault(key, new ArrayList<>());
            list.add(s);
            g.put(key, list);

        }
        return new ArrayList<>(g.values());

    }

}

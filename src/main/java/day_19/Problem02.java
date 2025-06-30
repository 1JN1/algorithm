package day_19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/10/3
 * @description 字母异位词分组
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

    }

    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // 记录字符串中每个字符出现的字数
            int[] counts = new int[26];

            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < 26; i++) {

                if (counts[i] > 0) {
                    builder.append((char) (i + 'a'));
                    builder.append(counts[i]);
                }

            }

            List<String> list = map.getOrDefault(builder.toString(), new ArrayList<>());
            list.add(str);

            map.put(builder.toString(), list);
        }

        return new ArrayList<>(map.values());
    }

}

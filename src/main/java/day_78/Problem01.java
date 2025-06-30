package day_78;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/1/26
 * @description 根据字符出现的次数排序
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(frequencySort2("Aabb"));

    }


    public String frequencySort(String s) {


        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }


        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {

            char ch = entry.getKey();
            int num = entry.getValue();
            for (int i = 0; i < num; i++) {
                sb.append(ch);
            }

        }


        return sb.toString();
    }

    public String frequencySort2(String s) {

        // 统计每个字符出现的次数，以及最大次数
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int frequency = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), frequency);
            max = Math.max(max, frequency);
        }

        // 创建max个桶
        StringBuffer[] sbs = new StringBuffer[max + 1];
        for (int i = 0; i < max + 1; i++) {
            sbs[i] = new StringBuffer();
        }

        map.forEach((k, v) -> sbs[v].append(k));

        StringBuffer sb = new StringBuffer();

        for (int i = max; i > 0; i--) {

            // 桶中有多少个字符
            StringBuffer sb1 = sbs[i];
            int size = sb1.length();

            for (int j = 0; j < size; j++) {

                for (int k = 0; k < i; k++) {
                    sb.append(sb1.charAt(j));
                }

            }


        }


        return sb.toString();
    }

}

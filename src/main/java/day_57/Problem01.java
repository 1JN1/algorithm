package day_57;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/22
 * @description 至多包含K个不同字符的最长子串
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(lengthOfLongestSubstringKDistinct("aa", 3));

    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int len = 0;

        int start = 0, end = 0;

        while (end < s.length()) {

            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                end++;
            } else if (k > 0) {
                map.put(c, 1);
                k--;
                end++;
            } else {
                len = Math.max(len, end - start);

                // 移动start，直到map中只包含k-1个字符
                while (true) {
                    c = s.charAt(start++);
                    map.put(c, map.get(c) - 1);

                    if (map.get(c) == 0) {
                        map.remove(c);
                        k++;
                        break;
                    }

                }
            }

        }

        len = Math.max(len, end - start);

        return len;
    }

}

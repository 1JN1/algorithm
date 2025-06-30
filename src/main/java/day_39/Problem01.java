package day_39;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2024/11/4
 * @description 至多包含两个不同字符的最长子串
 **/
public class Problem01 {

    @Test
    public void test() {

        String s = "eceba";

        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int ans = 0;

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0, right = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while (right < n) {

            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                right++;
            } else {

                if (map.size() == 2) {
                    int len = right - left;
                    ans = Math.max(ans, len);

                    // 移动左指针，直到map中的键值对数小于2
                    while (map.size() == 2) {

                        char c1 = s.charAt(left);
                        map.put(c1, map.get(c1) - 1);
                        left++;
                        if (map.get(c1) == 0) {
                            map.remove(c1);
                        }
                    }
                }

                map.put(c, 1);
                right++;

            }
        }

        return ans;
    }
}

package day_02;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2024/9/5
 * @description 无重复字符的最常子串
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }


    public int lengthOfLongestSubstring(String s) {


        // 最大长度和右边界
        int maxLength = 0, right = -1, n = s.length();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {


            if (maxLength >= n - i) {
                break;
            }


            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }

            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }

            maxLength = Math.max(maxLength, right - i + 1);


        }

        return maxLength;

    }

}

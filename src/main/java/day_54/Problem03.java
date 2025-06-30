package day_54;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/11/19
 * @description 去除重复字母
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(removeDuplicateLetters("bcabc"));

        Stack s = new Stack();

    }

    public String removeDuplicateLetters(String s) {

        // 判断当前字符是否已经添加进去
        boolean[] visited = new boolean[26];
        // 统计每个字符出现的次数
        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            // 当前字符没有访问过
            if (!visited[ch - 'a']) {
                // 最后一个字符的字典序大于当前字符
                while (builder.length() > 0 && builder.charAt(builder.length() - 1) > ch) {
                    // 最后一个字符在后面还会出现
                    if (nums[builder.charAt(builder.length() - 1) - 'a'] > 0) {
                        // 删除最后一个字符
                        visited[builder.charAt(builder.length() - 1) - 'a'] = false;
                        builder.deleteCharAt(builder.length() - 1);
                    } else {
                        break;
                    }
                }

                builder.append(ch);
                visited[ch - 'a'] = true;
            }

            nums[ch - 'a']--;
        }

        return builder.toString();
    }

}

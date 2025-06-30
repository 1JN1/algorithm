package day_70;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/1/16
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {


        System.out.println(longestSubstring("ababbc", 2));
    }


    public int longestSubstring(String s, int k) {


        return longestSubstringHelper(s, k, 0, s.length() - 1);
    }

    public int longestSubstringHelper(String s, int k, int start, int end) {

        if (end - start + 1 < k) {
            return 0;
        }

        // 统计每个字符出现的次数
        int[] count = new int[26];

        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }

        int idx = start;
        for (int i = start; i <= end; i++) {

            if (count[s.charAt(i) - 'a'] < k) {
                idx = i;
                break;
            }

        }


        if (idx == start && count[s.charAt(idx) - 'a'] >= k) {
            return end - start + 1;
        }

        int ret = 0;
        int i = start;
        while (i <= end) {

            while (i <= end && s.charAt(i) == s.charAt(idx)) {
                i++;
            }

            if (i > end) {
                break;
            }

            int l = i;
            while (i <= end && s.charAt(i) != s.charAt(idx)) {
                i++;
            }

            int length = longestSubstringHelper(s, k, l, i - 1);

            ret = Math.max(ret, length);
        }

        return ret;
    }


}

package day_175;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/25 11:03
 */
public class Problem03 {

    @Test
    public void test() {

        String[] words = {
                "mass", "as", "hero", "superhero"
        };

        System.out.println(stringMatching(words));

    }

    public List<String> stringMatching(String[] words) {

        List<String> ans = new ArrayList<>();

        int len = words.length;

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 0; i < len; i++) {
            String t = words[i];
            for (int j = i + 1; j < len; j++) {
                String s = words[j];
                if (contains(s, t)) {
                    ans.add(t);
                    break;
                }
            }
        }

        return ans;
    }


    private boolean contains(String s, String t) {

        if (s.length() < t.length()) {
            return false;
        }

        return kmpSearch(s, t) != -1;
    }

    private int kmpSearch(String s, String t) {

        int m = s.length(), n = t.length();

        if (n == 0) {
            return 0;
        }

        // 构建next数组
        int[] next = new int[n + 1];
        for (int i = 1, j = 0; i < n; i++) {

            if (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }

            if (t.charAt(i) == t.charAt(j)) {
                j++;
            }

            next[i] = j;
        }

        // 搜索
        for (int i = 0, j = 0; i < m; i++) {

            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }

            if (j == n) {
                return i - j + 1;
            }

        }

        return -1;
    }
}

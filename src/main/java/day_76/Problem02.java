package day_76;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/1/23
 * @description 找到字符串中所有字母异位词
 **/
public class Problem02 {

    @Test
    public void test() {


        System.out.println(findAnagrams2("cbaebabacd", "abc"));

    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int m = s.length(), n = p.length();

        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int[] counts = new int[26];

        while (right < m) {

            if (!map.containsKey(s.charAt(right))) {
                Arrays.fill(counts, 0);
                right++;
                left = right;
            }

            if (right >= m) {
                break;
            }

            counts[s.charAt(right) - 'a']++;
            right++;

            if (right - left == n) {
                boolean flag = true;
                for (int i = 0; i < n; i++) {
                    char c = p.charAt(i);
                    if (counts[c - 'a'] != map.get(c)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result.add(left);
                }
                counts[s.charAt(left) - 'a']--;
                left++;
            }

        }

        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {

        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        int[] counts = new int[26];

        for (int i = 0; i < pLen; i++) {
            counts[s.charAt(i) - 'a']++;
            counts[p.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0) {
                diff++;
            }
        }

        if (diff == 0) {
            result.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {

            char c = s.charAt(i);
            if (counts[c - 'a'] == 1) {
                diff--;
            } else if (counts[c - 'a'] == 0) {
                diff++;
            }

            counts[c - 'a']--;

            c = s.charAt(i + pLen);
            if (counts[c - 'a'] == -1) {
                diff--;
            } else if (counts[c - 'a'] == 0) {
                diff++;
            }

            counts[c - 'a']++;

            if (diff == 0) {
                result.add(i + 1);
            }

        }

        return result;
    }

}

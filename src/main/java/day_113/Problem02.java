package day_113;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/21
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        String s1 = "ab", s2 = "eidbaooo";

        System.out.println(checkInclusion1(s1, s2));

    }

    public boolean checkInclusion(String s1, String s2) {


        int len1 = s1.length(), len2 = s2.length();

        // 统计s1中每个字母出现的次数
        int[] s1Count = new int[26];

        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }

        // 遍历s2，查找s2中是否存在一个长度为len1的子序列，序列中各字符出现的次数与s1相同
        for (int i = 0; i < len2; i++) {
            // 剩余长度不足
            if (i + len1 > len2) {
                break;
            }
            // 当前字符不在s1中
            if (s1Count[s2.charAt(i) - 'a'] == 0) {
                continue;
            }

            int[] s2Count = new int[26];
            System.arraycopy(s1Count, 0, s2Count, 0, 26);
            for (int j = i; j < i + len1; j++) {
                char c = s2.charAt(j);
                s2Count[c - 'a']--;
                if (s2Count[c - 'a'] < 0) {
                    break;
                }
            }

            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (s2Count[j] != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public boolean checkInclusion1(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();

        // 此时s2不可能存在与s1各字符出现次数相同的子串
        if (len1 > len2) {
            return false;
        }

        int[] count = new int[26];
        // 维护长度为len1的窗口大小
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }

        // 记录当前窗口中，不同字符的个数
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                diff++;
            }
        }

        // 窗口中不同字符的个数不为0，则存在与s1各字符出现次数相同的子串
        if (diff == 0) {
            return true;
        }

        // 遍历s2中剩余字符，判断是否存在目标窗口
        for (int i = len1; i < len2; i++) {

            int x = s2.charAt(i) - 'a';
            // 要移除窗口的元素
            int y = s2.charAt(i - len1) - 'a';

            // 要对x字符的出现次数增加，所以原来是0的话会导致diff增加
            if (count[x] == 0) {
                diff++;
            }
            count[x]++;
            // 增加以后，次数为0，则diff减少
            if (count[x] == 0) {
                diff--;
            }

            if (count[y] == 0) {
                diff++;
            }
            count[y]--;
            if (count[y] == 0) {
                diff--;
            }

            // 当前窗口为目标窗口
            if (diff == 0) {
                return true;
            }
        }

        return false;
    }

}

package day_74;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/21
 * @description 替换后的最长重复字符
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(characterReplacement2("AABABBA", 1));

    }

    public int characterReplacement(String s, int k) {

        int n = s.length();
        int max = 0, idx = 0;

        while (idx < n) {
            int len = 0;
            int firstDifferent = idx;
            int m = k;
            for (int i = idx; i < n; i++) {

                if (s.charAt(i) == s.charAt(idx)) {
                    len++;
                } else {
                    if (firstDifferent == idx) {
                        firstDifferent = i;
                    }
                    if (m != 0) {
                        m--;
                        len++;
                    } else {
                        break;
                    }
                }

            }

            len = Math.min(len + m, n);

            max = Math.max(max, len);
            if (idx != firstDifferent) {
                idx = firstDifferent;
            } else {
                break;
            }

        }


        return max;
    }

    public int characterReplacement2(String s, int k) {

        int len = s.length();

        if (len < 2) {
            return len;
        }

        int ans = 0, left = 0, right = 0, maxCount = 0;
        int[] nums = new int[26];

        while (right < len) {

            char c = s.charAt(right);
            nums[c - 'A']++;
            // [left ~ right] 出现最多的字符的个数
            maxCount = Math.max(maxCount, nums[c - 'A']);
            right++;

            // 替换k个字符后依然小于区间长度
            if (right - left > maxCount + k) {

                c = s.charAt(left);
                nums[c - 'A']--;
                left++;

            }

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}

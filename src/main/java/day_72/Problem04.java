package day_72;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/18
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println((int) 'z');
    }

    public int longestPalindrome(String s) {

        // 统计每个字符出现的次数
        int[] count = new int[58];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }


        int sum = 0;
        for (int i = 0; i < 58; i++) {

            sum += count[i] / 2 * 2;

            if (count[i] % 2 != 0 && sum % 2 == 0) {
                sum++;
            }

        }

        return sum;
    }

}

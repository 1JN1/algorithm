package day_166;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/30
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(findKthNumber(13));
    }

    public int findKthNumber(int k) {
        if (k <= 9) {
            return k;
        }

        k -= 9;
        long left = 10, right = 99;
        int number = 2;
        long total = 180;

        while (k > total) {
            k -= total;
            number++;
            left = right + 1;
            right = right * 10 + 9;
            total = (right - left + 1) * number;
        }

        int index = (k - 1) / number;
        int remainder = (k % number == 0) ? number : k % number;

        long num = left + index;
        String numStr = String.valueOf(num);
        return numStr.charAt(remainder - 1) - '0';
    }

}

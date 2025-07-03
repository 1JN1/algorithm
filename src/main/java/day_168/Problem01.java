package day_168;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/7/3
 * @description
 **/
public class Problem01 {

    public int maxProduct(int n) {

        // 找出每一位数字
        String numStr = String.valueOf(n);

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        // 找出最大的两个数字
        int len = numStr.length();

        char[] numChars = numStr.toCharArray();

        for (int i = 0; i < len; i++) {
            int num = numChars[i] - '0';
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 * max2;
    }

}

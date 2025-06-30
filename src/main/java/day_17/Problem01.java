package day_17;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/30
 * @description 字符串相乘
 **/
public class Problem01 {

    @Test
    public void test() {


        System.out.println(multiply("2", "3"));
        ;

    }

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length(), len2 = num2.length();

        // 长度为len1和len2的两个数乘积的长度为len1 + len2 - 1或者 len1 + len2
        int[] arr = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {

            int a = num1.charAt(i) - '0';

            for (int j = len2 - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';

                arr[i + j + 1] += a * b;
            }

        }

        // 处理进位
        for (int i = len1 + len2 - 1; i >= 0; i--) {
            // 进位信息
            int num = 0;
            if (arr[i] >= 10) {
                num = arr[i] / 10;
                arr[i] %= 10;
            }
            if (i > 0) {
                arr[i - 1] += num;
            }
        }

        // 将数组处理成结果字符串
        StringBuilder builder = new StringBuilder();

        int i = 0;
        // 跳过前面的0
        while (arr[i] == 0) {
            i++;
        }

        for (; i < len1 + len2; i++) {
            builder.append(arr[i]);
        }

        return builder.toString();
    }

}

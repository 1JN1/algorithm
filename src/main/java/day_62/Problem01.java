package day_62;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/29
 * @description 统计各位数字都不同的数字个数
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(countNumbersWithUniqueDigits(3));

    }


    public int countNumbersWithUniqueDigits(int n) {

        int dp0 = 1;

        for (int i = 1; i <= n; i++) {

            int count = 9;
            for (int j = 1; j < i; j++) {
                count *= (10 - j);
            }

            dp0 += count;

        }

        return dp0;
    }
}

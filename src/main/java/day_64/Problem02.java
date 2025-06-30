package day_64;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/12/1
 * @description 两整数之和
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(getSum(-500, 1000));

    }

    public int getSum(int a, int b) {

        int result = 0;

        int num = 0;

        for (int i = 0; i < 32; i++) {

            int num1 = (a >> i) & 1;
            int num2 = (b >> i) & 1;

            if (num1 == 1 && num2 == 1) {

                result |= num << i;

                num = 1;

            } else if (num1 == 1 || num2 == 1) {
                result |= (1 - num) << i;
            } else {
                result |= num << i;
                num = 0;
            }

        }

        return result;
    }

}

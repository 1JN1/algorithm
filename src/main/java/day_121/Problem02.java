package day_121;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/4/15
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(generateKey(123, 456, 789));
        System.out.println(generateKey(1, 10, 1000));
        System.out.println(generateKey(987, 879, 798));
    }

    public int generateKey(int num1, int num2, int num3) {

        int ans = 0;

        for (int i = 3; i >= 0; i--) {

            int digit1 = num1 / (int) Math.pow(10, i);
            int digit2 = num2 / (int) Math.pow(10, i);
            int digit3 = num3 / (int) Math.pow(10, i);

            int digit = Math.min(digit1, Math.min(digit2, digit3));

            ans = ans * 10 + digit;

            num1 = num1 % (int) Math.pow(10, i);
            num2 = num2 % (int) Math.pow(10, i);
            num3 = num3 % (int) Math.pow(10, i);
        }

        return ans;
    }
}

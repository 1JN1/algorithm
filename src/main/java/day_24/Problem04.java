package day_24;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/10
 * @description 加一
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(Arrays.toString(plusOne(new int[]{1})));

    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

}

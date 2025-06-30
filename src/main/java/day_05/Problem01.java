package day_05;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/10
 * @description 整数转罗马数字
 **/

public class Problem01 {


    @Test
    public void test() {

        System.out.println(intToRoman(3999));

    }

    public String intToRoman(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        if (num >= 4000) {
            return null;
        }

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];

    }


}

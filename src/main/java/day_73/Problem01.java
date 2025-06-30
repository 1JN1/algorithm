package day_73;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/19
 * @description 字符串相加
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(addStrings("1", "9"));

    }

    public String addStrings(String num1, String num2) {


        StringBuffer sb = new StringBuffer();

        int i = num1.length() - 1, j = num2.length() - 1;

        // 进位
        int carry = 0;

        while (i >= 0 && j >= 0) {

            int num = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            i--;
            j--;

            sb.append(num % 10);
            carry = num / 10;

        }

        while (i >= 0) {
            int num = num1.charAt(i) - '0' + carry;
            i--;
            sb.append(num % 10);
            carry = num / 10;
        }

        while (j >= 0) {
            int num = num2.charAt(j) - '0' + carry;
            j--;
            sb.append(num % 10);
            carry = num / 10;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

}

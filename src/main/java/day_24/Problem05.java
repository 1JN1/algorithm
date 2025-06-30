package day_24;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/10
 * @description 二进制求和
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(addBinary("101111", "10"));

    }

    public String addBinary(String a, String b) {

        StringBuilder builder = new StringBuilder();

        int m = a.length() - 1, n = b.length() - 1, carry = 0;

        while (m >= 0 && n >= 0) {

            if (a.charAt(m) == '1' && b.charAt(n) == '1') {
                builder.append(carry);
                carry = 1;
            } else if (a.charAt(m) == '1') {
                if (carry == 0) {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
            } else if (b.charAt(n) == '1') {
                if (carry == 0) {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
            } else {
                builder.append(carry);
                carry = 0;
            }

            m--;
            n--;

        }

        while (m >= 0) {
            if (a.charAt(m) == '1') {
                if (carry == 1) {
                    builder.append('0');
                } else {
                    builder.append('1');
                }
            } else {
                builder.append(carry);
                carry = 0;
            }
            m--;
        }

        while (n >= 0) {
            if (b.charAt(n) == '1') {
                if (carry == 1) {
                    builder.append('0');
                } else {
                    builder.append('1');
                }
            } else {
                builder.append(carry);
                carry = 0;
            }
            n--;
        }

        if (carry != 0) {
            builder.append(carry);
        }

        builder.reverse();

        return builder.toString();
    }

}

package day_72;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/18
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {


        System.out.println(toHex(21));

    }

    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 7; i >= 0; i--) {

            int val = (num >> (i * 4)) & 0xf;

            if (sb.length() > 0 || val > 0) {
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }

        }


        return sb.toString();
    }

}

package day_174;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/22 9:52
 */
public class Problem01 {

    @Test
    public void test(){

        int num = 14;

        System.out.println(numberOfSteps(num));

    }

    public int numberOfSteps(int num) {

        int count = 0;


        while (num != 0) {
            // 判断num二进制最后一位是0还是1
            int lowBit = num & 1;
            if (lowBit == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            count++;
        }

        return count;
    }

}

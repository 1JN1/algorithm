package day_79;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/1
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(hammingDistance(3, 1));

    }

    public int hammingDistance(int x, int y) {

        int distance = 0;

        for (int i = 31; i >= 0; i--) {

            int num1 = x & (1 << i);
            int num2 = y & (1 << i);
            if (num1 != num2) {
                distance++;
            }

        }

        return distance;
    }
}

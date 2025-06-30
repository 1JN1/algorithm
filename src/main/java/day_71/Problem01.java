package day_71;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/17
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {


        System.out.println(findNthDigit(190));

    }

    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }
}

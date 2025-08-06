package day_182;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/6 9:30
 */
public class Problem01 {

    @Test
    public void test() {
        System.out.println(smallestNumber(8));
    }

    public int smallestNumber(int n) {

        int num = Integer.highestOneBit(n);

        return num | (num - 1);
    }

}

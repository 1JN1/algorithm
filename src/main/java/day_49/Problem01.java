package day_49;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 各位相加
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public int addDigits(int num) {

        return (num - 1) % 9 + 1;
    }

}

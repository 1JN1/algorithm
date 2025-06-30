package day_49;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/14
 * @description 丑数
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(isUgly(14));

    }

    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        while (n != 1) {

            if (n % 2 == 0) {
                n /= 2;
            }else if (n % 3 == 0) {
                n /= 3;
            }else if (n % 5 == 0) {
                n /= 5;
            }else {
                return false;
            }
        }

        return true;
    }

}

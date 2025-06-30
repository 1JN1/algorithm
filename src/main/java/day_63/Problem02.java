package day_63;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/30
 * @description 有效的完全平方数
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(isPerfectSquare(808201));

    }

    public boolean isPerfectSquare(int num) {


        if (num == 1) {
            return true;
        }

        int left = 1, right = num / 2;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;
    }

}

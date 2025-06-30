package day_110;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/18
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(brokenCalc(1, 1000000000));
    }

    public int brokenCalc(int startValue, int target) {

        int ans = 0;

        while (target > startValue) {

            if (target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
            ans++;

        }

        return ans + startValue - target;
    }

}

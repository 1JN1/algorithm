package day_56;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/21
 * @description 比特位计数
 **/
public class Problem05 {

    @Test
    public void test() {

        System.out.println(Arrays.toString(countBits(14)));

    }

    public int[] countBits(int n) {

        int[] res = new int[n + 1];

        res[0] = 0;
        int pre = 1;

        for (int i = 1; i <= n; i++) {

            if (i >= pre * 2) {
                pre *= 2;
            }

            res[i] = res[i - pre] + 1;

        }

        return res;
    }


    public int[] countBits2(int n) {

        int[] res = new int[n + 1];
        int highBit = 0;

        for (int i = 1; i <= n; i++) {

            if ((i & (i - 1)) == 0) {
                highBit = i;
            }

            res[i] = res[i - highBit] + 1;
        }

        return res;
    }

}

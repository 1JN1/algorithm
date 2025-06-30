package day_43;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/8
 * @description 计数质数
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(countPrimes2(10));

    }

    public int countPrimes(int n) {

        int count = 0;
        boolean flag = false;

        for (int i = 2; i < n; i++) {

            flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
            }
        }

        return count;
    }

    /**
     * 埃拉托斯特尼筛法
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {

        int count = 0;

        boolean[] flag = new boolean[n];

        Arrays.fill(flag, true);

        for (int i = 2; i < n; i++) {

            if (flag[i]) {

                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        flag[j] = false;
                    }
                }

            }

        }

        return count;
    }


}

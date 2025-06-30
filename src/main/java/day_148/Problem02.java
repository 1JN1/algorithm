package day_148;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/27
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(consecutiveNumbersSum2(15));
    }

    public int consecutiveNumbersSum(int n) {

        int count = 0;

        int len = (n + 1) / 2;

        for (int i = 1; i <= len; i++) {
            int total = i;
            for (int j = i + 1; j <= len; j++) {
                total += j;
                if (total == n) {
                    count++;
                } else if (total > n) {
                    break;
                }
            }
        }

        return count == len ? count : count + 1;
    }

    public int consecutiveNumbersSum2(int n) {
        int count = 0;
        int maxK = (int) Math.sqrt(2 * n);
        for (int k = 1; k <= maxK; k++) {
            if ((2 * n) % k == 0) {
                int temp = (2 * n) / k - k + 1;
                if (temp > 0 && temp % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}

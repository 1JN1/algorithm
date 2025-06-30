package day_141;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/5/19
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int n = 4;
        int k = 4;
        int[] ans = circularGameLosers(n, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] circularGameLosers(int n, int k) {

        int[] people = new int[n];

        int count = 1;

        int i = 0;
        while (people[i] != 1) {
            people[i] = 1;
            i = (i + k * count) % n;
            count++;
        }

        int[] ans = new int[n];

        int idx = 0;
        for (int j = 0; j < n; j++) {
            if (people[j] == 0) {
                ans[idx++] = j + 1;
            }
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }
}

package day_178;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/29 9:30
 */
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {80, 43, 53, 45, 100};

        System.out.println(maximumPrimeDifference(nums));
    }


    private static boolean b = false;

    private static boolean[] isPrime = new boolean[101];

    private void init() {

        if (b) {
            return;
        }

        b = true;

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 11; i++) {

            if (isPrime[i]) {
                for (int j = i * i; j <= 100; j += i) {
                    isPrime[j] = false;
                }
            }

        }
    }

    public int maximumPrimeDifference(int[] nums) {

        init();

        int start = -1, end = -1;

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (isPrime[nums[i]]) {
                start = start == -1 ? i : start;
                end = i;
            }
        }

        return end - start;
    }


}

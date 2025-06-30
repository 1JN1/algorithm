package day_146;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/25
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] bucket = {0};
        int[] vat = {1};
        System.out.println(storeWater(bucket, vat));
    }

    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int maxVat = 0;
        for (int v : vat) {
            maxVat = Math.max(maxVat, v);
        }
        if (maxVat == 0) {
            return 0;
        }

        int minOperations = Integer.MAX_VALUE;
        for (int k = 1; k <= maxVat; k++) {
            int operations = k;
            for (int i = 0; i < n; i++) {
                if (vat[i] == 0) {
                    continue;
                }
                operations += Math.max(0, (vat[i] + k - 1) / k - bucket[i]);
                if (operations >= minOperations) {
                    break; // 提前终止，因为已经不可能更优
                }
            }
            minOperations = Math.min(minOperations, operations);
        }
        return minOperations;
    }

}

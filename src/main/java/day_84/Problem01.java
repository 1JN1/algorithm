package day_84;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));

    }


    public int maximumGap(int[] nums) {

        int n = nums.length;

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        if (max - min <= 1) {
            return max - min;
        }

        // 最大间隔不小于
        int d = (max - min + n - 2) / (n - 1);

        int[][] buckets = new int[(max - min) / d + 1][2];

        for (int[] bucket : buckets) {
            bucket[0] = Integer.MAX_VALUE;
            bucket[1] = Integer.MIN_VALUE;
        }

        // 维护每一个桶中的最大值和最小值
        for (int num : nums) {

            int[] bucket = buckets[(num - min) / d];
            bucket[0] = Math.min(bucket[0], num);
            bucket[1] = Math.max(bucket[1], num);

        }

        int ans = 0, preMax = Integer.MAX_VALUE;

        for (int[] bucket : buckets) {

            // 不是空桶
            if (bucket[0] != Integer.MAX_VALUE) {

                ans = Math.max(ans, bucket[0] - preMax);
                preMax = bucket[1];
            }

        }

        return ans;
    }

}

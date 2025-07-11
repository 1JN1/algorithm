package day_172;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/11 10:07
 */
public class Problem02 {
    public int maxFrequencyElements(int[] nums) {

        // 统计每一个元素出现的次数，以及最大次数
        int[] count = new int[101];
        int maxCount = 0;
        for (int num : nums) {
            count[num]++;
            maxCount = Math.max(maxCount, count[num]);
        }

        // 求出所有频数为maxCount的元素的和
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (count[i] == maxCount) {
                sum++;
            }
        }

        return sum * maxCount;
    }
}

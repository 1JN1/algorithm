package day_172;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/11 9:46
 */
public class Problem01 {

    /**
     * 计算满足其元素的按位或运算结果至少为 k 的最短子数组的长度。
     *
     * @param nums 整数数组
     * @param k    目标值
     * @return 最短子数组的长度，如果不存在则返回 -1
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0) {
            return 1;
        }

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;

        // bitCounts[i] 记录当前窗口 [left, right] 中，第 i 位为 1 的数字个数
        int[] bitCounts = new int[32];
        long currentOrSum = 0;

        for (int right = 0; right < n; right++) {
            // 1. 将 nums[right] 添加到窗口中，并更新 bitCounts
            for (int i = 0; i < 32; i++) {
                if (((nums[right] >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
            // 直接更新当前窗口的或和
            currentOrSum |= nums[right];

            // 2. 当窗口满足条件时，尝试从左侧收缩
            while (left <= right && currentOrSum >= k) {
                // 找到一个有效子数组，更新最小长度
                minLength = Math.min(minLength, right - left + 1);

                // 3. 从窗口中移除 nums[left]
                for (int i = 0; i < 32; i++) {
                    if (((nums[left] >> i) & 1) == 1) {
                        bitCounts[i]--;
                        // 如果移除后，没有任何数贡献第 i 位，则更新或和
                        if (bitCounts[i] == 0) {
                            // 使用 long 型的 1L 来避免位移溢出
                            currentOrSum &= ~(1L << i);
                        }
                    }
                }
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

}

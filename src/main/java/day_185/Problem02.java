package day_185;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/18 9:33
 */
public class Problem02 {

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3};
        System.out.println(numberOfGoodPartitions(nums));
    }

    /**
     * 计算好分割方案的数量
     *
     * @param nums 输入数组
     * @return 分割方案数
     */
    public int numberOfGoodPartitions(int[] nums) {
        // LeetCode 题目通常要求对一个大数取模
        final int MOD = 1_000_000_007;

        // 步骤 1: 预处理，记录每个数字最后出现的位置
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            lastIndexMap.put(nums[i], i);
        }

        // 这个变量用来统计最小“好区间”的数量 k
        int partitionCount = 0;
        int i = 0;
        while (i < nums.length) {
            // 发现了一个新的区间，计数加一
            partitionCount++;

            // 确定当前这个区间的右边界
            // 初始右边界是当前元素的最后出现位置
            int endOfSegment = lastIndexMap.get(nums[i]);

            // 扫描当前区间 [i, endOfSegment]，看是否需要扩大区间的右边界
            int j = i;
            while (j <= endOfSegment) {
                // 获取区间内元素的最后出现位置
                int currentNumLastIndex = lastIndexMap.get(nums[j]);
                // 如果这个位置比已知的右边界还要远，就更新右边界
                if (currentNumLastIndex > endOfSegment) {
                    endOfSegment = currentNumLastIndex;
                }
                j++;
            }

            // 当前这个最小“好区间”已经确定，范围是 [i, endOfSegment]
            // 下一个区间的起点从 endOfSegment + 1 开始
            i = endOfSegment + 1;
        }

        // 步骤 2: 根据区间总数 k 计算结果 2^(k-1)
        // 注意：这里 k 就是 partitionCount
        // 如果只有一个区间，k=1，结果是 2^0 = 1
        return (int) power(2, partitionCount - 1, MOD);
    }

    /**
     * 快速幂计算 (base^exp) % mod，防止结果溢出
     *
     * @param base 底数
     * @param exp  指数
     * @param mod  模
     * @return 计算结果
     */
    private long power(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

}

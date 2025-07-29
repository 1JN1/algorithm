package day_178;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/29 9:45
 */
public class Problem02 {


    @Test
    public void test() {

        int[] nums = {4, 3, 1};

        System.out.println(minimumCost(nums));

    }

    private static final int[] pal = new int[109999];

    static {
        // 严格按顺序从小到大生成所有回文数（不用字符串转换）
        int palIdx = 0;
        for (int base = 1; base <= 10000; base *= 10) {
            // 生成奇数长度回文数
            for (int i = base; i < base * 10; i++) {
                int x = i;
                for (int t = i / 10; t > 0; t /= 10) {
                    x = x * 10 + t % 10;
                }
                pal[palIdx++] = x;
            }
            // 生成偶数长度回文数
            if (base <= 1000) {
                for (int i = base; i < base * 10; i++) {
                    int x = i;
                    for (int t = i; t > 0; t /= 10) {
                        x = x * 10 + t % 10;
                    }
                    pal[palIdx++] = x;
                }
            }
        }
        pal[palIdx++] = 1_000_000_001; // 哨兵，防止下面代码中的 i 下标越界
    }

    public long minimumCost(int[] nums) {
        // 注：排序只是为了找中位数，如果用快速选择算法，可以做到 O(n)
        Arrays.sort(nums);
        int n = nums.length;

        // 二分找中位数右侧最近的回文数
        int i = lowerBound(nums[(n - 1) / 2]);

        // 回文数在中位数范围内
        if (pal[i] <= nums[n / 2]) {
            return cost(nums, i); // 直接变成 pal[i]
        }

        // 枚举离中位数最近的两个回文数 pal[i-1] 和 pal[i]
        return Math.min(cost(nums, i - 1), cost(nums, i));
    }

    // 返回 nums 中的所有数变成 pal[i] 的总代价
    private long cost(int[] nums, int i) {
        int target = pal[i];
        long sum = 0;
        for (int x : nums) {
            sum += Math.abs(x - target);
        }
        return sum;
    }

    // 开区间写法
    private int lowerBound(int target) {
        int left = -1, right = pal.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            // 循环不变量：
            // pal[left] < target
            // pal[right] >= target
            int mid = left + (right - left) / 2;
            if (pal[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right; // 或者 left+1
    }
}

package day_179;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/31 10:24
 */
public class Problem02 {

    class MajorityChecker {

        /**
         * 存储每个数字出现的所有下标位置。
         * Key: 数字
         * Value: 有序的下标列表
         */
        private final Map<Integer, List<Integer>> positions;
        private final int[] arr;
        private final Random random;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
            this.positions = new HashMap<>();
            this.random = new Random();
            for (int i = 0; i < arr.length; i++) {
                positions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            // 随机抽样的次数，一个较小的常数即可保证高概率命中
            int attempts = 20;
            int length = right - left + 1;

            for (int i = 0; i < attempts; i++) {
                // 1. 随机在 [left, right] 区间内选择一个候选者
                int randomIndex = left + random.nextInt(length);
                int candidate = arr[randomIndex];

                // 2. 高效地计算该候选者在区间内的实际出现次数
                List<Integer> candidatePositions = positions.get(candidate);
                // 如果候选者出现次数本身就小于threshold，直接跳过
                if (candidatePositions.size() < threshold) {
                    continue;
                }

                int start = lowerBound(candidatePositions, left);
                int end = upperBound(candidatePositions, right);
                int count = end - start;

                // 3. 验证是否满足阈值
                if (count >= threshold) {
                    return candidate;
                }
            }

            return -1;
        }

        /**
         * 二分查找，找到第一个大于等于 target 的位置。
         */
        private int lowerBound(List<Integer> list, int target) {
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        /**
         * 二分查找，找到第一个大于 target 的位置。
         */
        private int upperBound(List<Integer> list, int target) {
            int low = 0;
            int high = list.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    @Test
    public void test() {

        int[] arr = {1, 1, 2, 2, 1, 1};

        MajorityChecker checker = new MajorityChecker(arr);

        System.out.println(checker.query(0, 5, 4));
        System.out.println(checker.query(0, 3, 3));
        System.out.println(checker.query(2, 3, 2));

    }

}

package day_171;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/10 9:55
 */
public class Problem02 {

    @Test
    public void test() {
        System.out.println(punishmentNumber(37));
    }


    static int[] penalties = new int[1001];

    static {
        for (int i = 1; i <= 1000; i++){
            penalties[i] = isPunishmentNumber(i) ? 1 : 0;
        }
    }

    /**
     * 判断给定的整数 n 是否是一个惩罚数。
     *
     * @param n 要检查的正整数。
     * @return 如果 n 是惩罚数，则返回 true；否则返回 false。
     */
    private static boolean isPunishmentNumber(int n) {
        if (n <= 0) {
            return false;
        }
        long square = (long) n * n;
        String s = String.valueOf(square);
        return canPartition(s, 0, 0, n);
    }

    /**
     * 使用回溯算法检查字符串 s 是否可以分割成和为 target 的整数。
     *
     * @param s          平方数的字符串表示。
     * @param index      当前处理的字符串起始索引。
     * @param currentSum 当前累加的和。
     * @param target     目标和，即原始数字 n。
     * @return 如果可以成功分割，返回 true；否则返回 false。
     */
    private static boolean canPartition(String s, int index, int currentSum, int target) {
        // 基本情况：成功
        // 如果已经处理到字符串末尾，并且当前和等于目标值，说明找到了一种有效的分割方式。
        if (index == s.length()) {
            return currentSum == target;
        }

        // 剪枝：如果当前和已经超过目标值，后续不可能成功。
        if (currentSum > target) {
            return false;
        }

        long num = 0;
        // 尝试从 index 开始的所有可能分割点
        for (int i = index; i < s.length(); i++) {
            // 从 s.charAt(i) 构建当前的子字符串数值
            num = num * 10 + (s.charAt(i) - '0');

            // 如果加上当前数值后超过了目标值，那么更长的子字符串也必然超过，可以提前终止循环。
            if (currentSum + num > target) {
                break;
            }

            // 递归调用，检查剩余部分能否凑成 target
            // 新的起始索引是 i + 1, 新的和是 currentSum + num
            if (canPartition(s, i + 1, currentSum + (int) num, target)) {
                return true;
            }
        }

        // 如果所有分割尝试都失败了
        return false;
    }


    public int punishmentNumber(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++){
            sum += penalties[i] == 1 ? i * i : 0;
        }

        return sum;
    }

}

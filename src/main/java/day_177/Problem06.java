package day_177;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 11:18
 */
public class Problem06 {

    @Test
    public void test() {
        int[] happiness = {2,3,4,5};
        int k = 1;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        // 按幸福值降序排序
        Arrays.sort(happiness);

        long sum = 0;
        int n = happiness.length;

        // 贪心选择：每次选择当前最大的幸福值
        for (int i = 0; i < k; i++) {
            // 当前孩子的实际幸福值 = 原始幸福值 - 已选择的孩子数量
            // 但幸福值不能低于0
            int actualHappiness = Math.max(0, happiness[n - 1 - i] - i);
            sum += actualHappiness;

            // 如果当前幸福值已经为0，后面的都会是0，可以提前退出
            if (actualHappiness == 0) {
                break;
            }
        }

        return sum;
    }

}

package day_169;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/7/4
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;
        System.out.println(closestCost1(baseCosts, toppingCosts, target));
    }

    /**
     * 存储所有可能的配料组合成本
     */
    private final Set<Integer> toppingCostsSet = new HashSet<>();

    /**
     * 主函数，计算最接近目标价格的成本
     */
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 步骤一：通过回溯计算所有可能的配料成本
        // 从第0种配料开始，初始成本为0
        dfs(toppingCosts, 0, 0);

        // 步骤二：遍历基料和配料成本的组合，寻找最优解
        // 初始化一个答案，可以设为第一个基料的价格，因为它是一个合法的方案
        int ans = baseCosts[0];

        // 遍历每一种基料
        for (int base : baseCosts) {
            // 遍历每一种可能的配料总成本
            for (int topping : toppingCostsSet) {
                // 计算当前的总成本
                int totalCost = base + topping;

                // 获取当前成本与目标的差距
                int diffTotal = Math.abs(totalCost - target);
                // 获取当前最优解与目标的差距
                int diffAns = Math.abs(ans - target);

                // 根据规则更新最优解 ans
                // 1. 如果当前成本更接近目标
                // 2. 或者，如果接近程度相同，但当前成本更低
                if (diffTotal < diffAns || (diffTotal == diffAns && totalCost < ans)) {
                    ans = totalCost;
                }
            }
        }
        return ans;
    }

    /**
     * 回溯函数，用于探索所有配料组合的可能性
     *
     * @param toppingCosts 配料成本数组
     * @param index        当前考虑的配料索引
     * @param currentCost  当前已累加的配料成本
     */
    private void dfs(int[] toppingCosts, int index, int currentCost) {
        // 终止条件：如果所有配料都已考虑完毕
        if (index == toppingCosts.length) {
            // 将当前这条路径产生的总配料成本加入集合
            toppingCostsSet.add(currentCost);
            return;
        }

        // --- 对于第 index 种配料，有三种选择 ---

        // 选择1：不加此配料
        dfs(toppingCosts, index + 1, currentCost);

        // 选择2：加一份此配料
        dfs(toppingCosts, index + 1, currentCost + toppingCosts[index]);

        // 选择3：加两份此配料
        dfs(toppingCosts, index + 1, currentCost + 2 * toppingCosts[index]);
    }

    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        int x = Arrays.stream(baseCosts).min().getAsInt();
        if (x >= target) {
            return x;
        }
        boolean[] can = new boolean[target + 1];
        int res = 2 * target - x;
        for (int b : baseCosts) {
            if (b <= target) {
                can[b] = true;
            } else {
                res = Math.min(res, b);
            }
        }
        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    if (can[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    if (i - t > 0) {
                        can[i] = can[i] | can[i - t];
                    }
                }
            }
        }
        for (int i = 0; i <= res - target; ++i) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;
    }

}

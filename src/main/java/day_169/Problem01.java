package day_169;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/7/4
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(countArrangement1(2));

    }


    private int count;

    /**
     * 计算优美排列数量的入口方法
     *
     * @param n 整数 n
     * @return 优美排列的数量
     */
    public int countArrangement(int n) {
        // 初始化计数器为 0
        this.count = 0;

        // 创建一个布尔数组 `visited` 来跟踪数字 1 到 n 是否已经被使用。
        // 数组大小为 n + 1，是为了让下标能直接对应数字 1 到 n，我们忽略索引 0。
        // Java 中布尔数组默认初始化为 false。
        boolean[] visited = new boolean[n + 1];

        // 从第 1 个位置开始进行回溯搜索
        backtrack(n, 1, visited);

        return this.count;
    }

    /**
     * 回溯算法的核心递归函数
     *
     * @param n       题目给定的整数 n
     * @param index   当前正在尝试填充的位置（从 1 到 n）
     * @param visited 记录数字是否已被使用的数组
     */
    private void backtrack(int n, int index, boolean[] visited) {
        // 1. 递归的终止条件
        // 如果 index 已经大于 n，说明我们已经为 1 到 n 的所有位置找到了合法的数字。
        // 这意味着我们成功构造了一个完整的优美排列。
        if (index > n) {
            count++; // 计数器加 1
            return;  // 结束当前递归分支
        }

        // 2. 遍历所有可能的选择
        // 尝试将数字 1 到 n 放入当前的 index 位置
        for (int num = 1; num <= n; num++) {

            // 3. 剪枝：检查当前选择是否合法
            // 条件一: 当前数字 num 必须是之前没有被使用过的 (visited[num] == false)
            // 条件二: num 和 index 必须满足优美排列的条件
            if (!visited[num] && (num % index == 0 || index % num == 0)) {

                // a. 做出选择
                visited[num] = true;

                // b. 进入下一层决策：为 index + 1 的位置寻找合适的数字
                backtrack(n, index + 1, visited);

                // c. 撤销选择 (回溯)
                // 当上一行递归返回后，无论是否找到解，都要把当前位置的选择撤销，
                // 以便 for 循环可以继续尝试其他数字。
                visited[num] = false;
            }
        }
    }

    public int countArrangement1(int n) {

        // f 是我们的 DP 数组。大小为 2^n，因为 n 个数字总共有 2^n 个子集（从全不选到全选）。
        // 数组的索引 `mask` 就代表一个子集。
        // `f[mask]` 存储的是：使用 `mask` 代表的数字集合，能构成优美排列的数量。
        int[] f = new int[1 << n];

        // 初始化基础情况 (Base Case)。
        // `f[0]` 表示使用空集（一个数字都不用）来排列的方法数。我们定义它为 1。
        // 这是所有后续计算的起点。
        f[0] = 1;

        // 外层循环遍历所有可能的子集状态 `mask`，从 1（只包含一个数）到 (2^n - 1)（包含所有数）。
        for (int mask = 1; mask < (1 << n); mask++) {

            // 计算当前 `mask` 中 '1' 的数量，即当前子集中有多少个数字。
            // 这个数量 `num` 也恰好是我们当前构建的排列的长度（或下一个要填充的位置索引）。
            int num = Integer.bitCount(mask);

            // 内层循环遍历数字 1 到 n (这里用 0 到 n-1 的索引 i 代表数字 i+1)。
            // 目的是检查 `mask` 这个状态可以由哪个更小的状态转移而来。
            // 换句话说，我们假设排列的最后一个数字（第 `num` 个）是 `i+1`。
            for (int i = 0; i < n; i++) {

                // 这个 if 判断包含两个关键条件：
                // 1. `(mask & (1 << i)) != 0`: 检查 `mask` 的第 `i` 位是否为 1。
                //    这确保了我们假设的最后一个数字 `i+1` 确实存在于当前子集 `mask` 中。
                // 2. `(num % (i + 1) == 0 || (i + 1) % num == 0)`: 这是优美排列的核心条件。
                //    检查我们假设放在第 `num` 个位置的数字 `i+1` 是否与位置 `num` 满足整除关系。
                if ((mask & (1 << i)) != 0 && (num % (i + 1) == 0 || (i + 1) % num == 0)) {

                    // 如果上述两个条件都满足，说明这是一个有效的状态转移。
                    // `f[mask]` 的值，可以从“不包含数字 i+1 的那个状态”的排列数累加而来。
                    // `mask ^ (1 << i)` 这个位运算操作会得到一个新的掩码，它恰好是 `mask` 去掉第 `i` 位 '1' 后的结果。
                    // 例如，mask=1011, i=1，mask^(1<<i)=1011^0010=1001。
                    // 这行代码的含义是：构成 `mask` 状态的排列数，等于所有构成其合法子状态的排列数之和。
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }

        // 最终的结果存储在 `f[(1 << n) - 1]` 中。
        // `(1 << n) - 1` 是一个所有 n 位都为 1 的掩码（例如 n=3, 它是 111(二进制)，即 7）。
        // 它代表了包含所有数字 {1, 2, ..., n} 的全集。
        // `f` 在这个索引上的值，就是我们要求的最终答案。
        return f[(1 << n) - 1];
    }

}

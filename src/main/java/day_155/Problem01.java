package day_155;

/**
 * @author 王文涛
 * @date 2025/6/7
 * @description
 **/
public class Problem01 {

    public int paintingPlan(int n, int k) {


        if (k == 0) {
            return 1;
        }

        if (n * n == k) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i * n + j * n - i * j == k) {
                    res += combination(n, i) * combination(n, j);
                }
            }
        }

        return res;
    }

    public int combination(int n, int k) {
        // 处理边界情况
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }

        // 使用较小的k值进行计算以减少乘法次数
        k = Math.min(k, n - k);

        // 使用long防止中间结果溢出
        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - k + i) / i;
        }

        return (int) result;
    }

}

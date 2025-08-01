package day_180;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/1 10:21
 */
public class Problem03 {

    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut); // 下面倒序遍历
        Arrays.sort(verticalCut);
        long ans = 0;
        int i = 0;
        int j = 0;
        while (i < m - 1 || j < n - 1) {
            if (j == n - 1 || i < m - 1 && horizontalCut[i] < verticalCut[j]) {
                ans += horizontalCut[i++] * (n - j); // 上下连边
            } else {
                ans += verticalCut[j++] * (m - i); // 左右连边
            }
        }
        return ans;
    }

}

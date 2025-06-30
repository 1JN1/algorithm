package day_117;

/**
 * @author 王文涛
 * @date 2025/4/11
 * @description
 **/
public class Problem01 {
    public int minimumTimeToInitialState(String word, int k) {

        char[] chars = word.toCharArray();
        int n = chars.length;

        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {

            // 当前索引位于z-box中
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }

            // 暴力遍历后序字符是否相等
            while (i + z[i] < n && chars[z[i]] == chars[i + z[i]]) {
                z[i]++;
                l = i;
                r = i + z[i];
            }

            // 当前剩余字符是否是初始字符串的前缀
            if (i % k == 0 && z[i] >= n - i) {
                return i;
            }

        }

        return (n - 1) / k + 1;
    }

}

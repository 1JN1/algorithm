package day_93;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/2/23
 * @description
 **/
public class Problem02 {


    private int[] nums;
    private int[] andValues;
    private Map<Long, Integer> map = new HashMap<>();
    private int inf = 1 << 29;
    private int n;
    private int m;

    public int minimumValueSum(int[] nums, int[] andValues) {

        this.nums = nums;
        this.andValues = andValues;
        this.n = nums.length;
        this.m = andValues.length;
        int ans = dfs(0, 0, -1);

        return ans >= inf ? -1 : ans;
    }

    public int dfs(int i, int j, int cur) {

        // 剩余元素不足以划分
        if (n - i < m - j) {
            return inf;
        }

        if (j == m) {
            return i == n ? 0 : inf;
        }

        cur &= nums[i];

        // 相与不会使元素值增大
        if (cur < andValues[j]) {
            return inf;
        }

        long key = (long) i << 30 | (long) j << 15 | cur;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans = dfs(i + 1, j, cur);

        if (cur == andValues[j]) {
            ans = Math.min(ans, dfs(i + 1, j + 1, -1) + nums[i]);
        }

        map.put(key, ans);

        return ans;
    }

}

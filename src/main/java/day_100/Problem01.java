package day_100;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/5
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {


        System.out.println(longestCycle(new int[]{3,3,4,2,3}));

    }

    public int longestCycle(int[] edges) {
        int n = edges.length, ans = -1;
        var time = new int[n];
        for (int i = 0, clock = 1; i < n; ++i) {
            // 该连通分量已经走过了
            if (time[i] > 0) continue;
            for (int x = i, startTime = clock; x >= 0; x = edges[x]) {
                if (time[x] > 0) { // 重复访问
                    if (time[x] >= startTime) // 找到了一个新的环
                        ans = Math.max(ans, clock - time[x]);
                    break;
                }
                time[x] = clock++;
            }
        }
        return ans;
    }

}

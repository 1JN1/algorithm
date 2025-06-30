package day_103;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/3/10
 * @description
 **/
public class Problem02 {

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {

        List<Integer>[] g = new ArrayList[values.length];

        Arrays.setAll(g, e -> new ArrayList<>());

        // 构造边
        // 避免误把根节点作为叶子节点
        g[0].add(-1);
        for (int[] edge : edges) {

            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }

        long value = 0;
        for (int v : values) {
            value += v;
        }

        return value - dfs(0, -1, g, values);
    }

    public long dfs(int x, int fa, List<Integer>[] g, int[] values) {

        // 叶子结点
        if (g[x].size() == 1) {
            return values[x];
        }

        long loss = 0;

        for (int y : g[x]) {
            if (y != fa) {
                loss += dfs(y, x, g, values);
            }
        }

        return Math.min(loss, values[x]);
    }

}

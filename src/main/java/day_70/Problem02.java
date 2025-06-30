package day_70;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/1/16
 * @description
 **/
public class Problem02 {

    class UnionFind {

        private int[] parent;
        private double[] weight;

        public UnionFind(int n) {

            parent = new int[n];
            weight = new double[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }

        }

        public void union(int p, int q, double value) {

            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return;
            }

            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * value / weight[p];

        }

        // 路径压缩
        public int find(int p) {

            if (p != parent[p]) {

                int origin = parent[p];
                parent[p] = find(parent[p]);
                weight[p] *= weight[origin];

            }

            return parent[p];
        }

        public double isConnected(int p, int q) {

            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) {
                return weight[p] / weight[q];
            }

            return -1.0d;
        }

    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


        UnionFind uf = new UnionFind(equations.size() * 2);

        Map<String, Integer> map = new HashMap<>();

        // 将字符串映射到数字id，构建并查集
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);

            String var1 = equation.get(0);
            String var2 = equation.get(1);

            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }

            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }

            uf.union(map.get(var1), map.get(var2), values[i]);
        }

        // 查询并查集，构造结果集
        double[] ret = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);

            String var1 = query.get(0);
            String var2 = query.get(1);

            Integer id1 = map.get(var1);
            Integer id2 = map.get(var2);

            if (id1 == null || id2 == null) {
                ret[i] = -1.0d;
            } else {
                ret[i] = uf.isConnected(id1, id2);
            }

        }

        return ret;
    }

}

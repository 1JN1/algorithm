package day_119;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/4/13
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(combine(10, 6));
    }


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(n, k, 1, path, res);

        return res;
    }


    public void dfs(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {

        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() + (n - start + 1) < k) {
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }

    }

}

package day_151;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/5/31
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(getHappyString(10, 100));
    }

    public String getHappyString(int n, int k) {

        List<String> path = new ArrayList<>(k);

        dfs(n, k, path, 0, new StringBuilder());

        return path.isEmpty() || k > path.size() ? "" : path.get(k - 1);
    }

    public void dfs(int n, int k, List<String> path, int index, StringBuilder sb) {

        if (index == n) {
            path.add(sb.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {

            if (path.size() == k) {
                return;
            }

            if (index > 0 && sb.charAt(index - 1) == (char) ('a' + i)) {
                continue;
            }

            sb.append((char) ('a' + i));
            dfs(n, k, path, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}

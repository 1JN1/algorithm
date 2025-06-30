package day_154;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/6/5
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(validPartition2(new int[]{803201, 803201, 803201, 803201, 803202, 803203}));
    }

    public boolean validPartition(int[] nums) {

        List<List<List<Integer>>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);

        return !res.isEmpty();
    }

    public boolean validPartition2(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            if (i >= 2 && dp[i - 2]) {
                if (nums[i - 2] == nums[i - 1]) {
                    dp[i] = true;
                    continue;
                }
            }
            if (i >= 3 && dp[i - 3]) {
                if (nums[i - 3] == nums[i - 2] && nums[i - 2] == nums[i - 1]) {
                    dp[i] = true;
                    continue;
                }
                if (nums[i - 3] + 1 == nums[i - 2] && nums[i - 2] + 1 == nums[i - 1]) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }

    public void dfs(int[] nums, int start, List<List<Integer>> path, List<List<List<Integer>>> res) {

        if (start == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (start + 1 < nums.length && nums[start] == nums[start + 1]) {
            path.add(new ArrayList<>(List.of(nums[start], nums[start + 1])));
            dfs(nums, start + 2, path, res);
            path.remove(path.size() - 1);
        }
        if (start + 2 < nums.length && nums[start] == nums[start + 1] && nums[start] == nums[start + 2]) {
            path.add(new ArrayList<>(List.of(nums[start], nums[start + 1], nums[start + 2])));
            dfs(nums, start + 3, path, res);
            path.remove(path.size() - 1);
        }
        if (start + 2 < nums.length && nums[start] == nums[start + 1] - 1 && nums[start] == nums[start + 2] - 2) {
            path.add(new ArrayList<>(List.of(nums[start], nums[start + 1], nums[start + 2])));
            dfs(nums, start + 3, path, res);
            path.remove(path.size() - 1);
        }
    }

}

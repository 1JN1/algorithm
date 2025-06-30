package day_16;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/9/28
 * @description 组合总数
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        combinationSumHelper(candidates, target, 0, 0, ans, list);

        return ans;
    }

    public void combinationSumHelper(int[] candidates, int target, int start, int sum, List<List<Integer>> ans, List<Integer> path) {

        // 以满足条件，将当前路径假如答案
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            path.add(candidates[i]);
            sum += candidates[i];

            combinationSumHelper(candidates, target, i, sum, ans, path);

            // 回退
            path.remove(path.size() - 1);
            sum -= candidates[i];

        }

    }

}

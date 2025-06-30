package day_16;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/9/28
 * @description 组合总数二
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        combinationSum2Helper(candidates, target, 0, 0, res, list);

        return res;
    }

    public void combinationSum2Helper(int[] candidates, int target, int start, int sum, List<List<Integer>> res, List<Integer> path) {

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (target - candidates[i] < 0) {
                break;
            }

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];

            combinationSum2Helper(candidates, target, i + 1, sum, res, path);

            path.remove(path.size() - 1);
            sum -= candidates[i];
        }

    }

}

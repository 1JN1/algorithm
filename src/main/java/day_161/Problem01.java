package day_161;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/6/21
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, 0, new ArrayList<>(), res);


        return res;
    }

    public void dfs(int[] nums, int i, List<Integer> path, List<List<Integer>> res){
        res.add(new ArrayList<>(path));
        for (int j = i; j < nums.length; j++) {
            path.add(nums[j]);
            dfs(nums, j + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

}

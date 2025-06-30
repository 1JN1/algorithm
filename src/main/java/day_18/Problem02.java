package day_18;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/10/2
 * @description 全排列 II
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(permute(new int[]{1, 3, 1, 1}));

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        boolean[] flag = new boolean[nums.length];

        List<Integer> path = new ArrayList<>();

        Arrays.sort(nums);

        permuteHelper(nums, res, path, flag);

        return res;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] flag) {

        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) {
                continue;
            }

            if (!flag[i]) {
                flag[i] = true;
                path.add(nums[i]);

                permuteHelper(nums, ans, path, flag);

                flag[i] = false;
                path.remove(path.size() - 1);
            }

        }

    }

}

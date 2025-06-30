package day_18;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/10/2
 * @description 全排列
 **/
public class Problem01 {

    @Test
    public void test() {

        System.out.println(permute(new int[]{1, 3, 1, 1}));

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        for (int num : nums) {
            path.add(num);
        }

        permuteHelper(res, path, 0);

        return res;
    }

    public void permuteHelper(List<List<Integer>> res, List<Integer> path, int first) {

        if (first == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = first; i < path.size(); i++) {

            Collections.swap(path, first, i);

            permuteHelper(res, path, first + 1);

            Collections.swap(path, first, i);

        }

    }

}

package day_26;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/12
 * @description 子集
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(subsets1(new int[]{1, 9, 8, 3, -1, 0}));

    }


    public List<List<Integer>> subsets1(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int n = nums.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            path.clear();

            for (int i = 0; i < n; ++i) {

                if ((mask & (1 << i)) != 0) {
                    path.add(nums[i]);
                }

            }

            res.add(new ArrayList<>(path));

        }

        System.out.println(res.size());

        return res;
    }


    public List<List<Integer>> subsets(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 1; i <= nums.length; i++) {

            List<List<Integer>> temp = combine(nums, i);

            res.addAll(temp);
        }

        return res;
    }

    public List<List<Integer>> combine(int[] nums, int len) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        combineHelper(nums, len, 0, res, path);
        return res;
    }


    public void combineHelper(int[] nums, int len, int begin, List<List<Integer>> res, List<Integer> path) {

        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (path.size() + (nums.length - begin) < len) {
            return;
        }

        for (int i = begin; i < nums.length; i++) {

            path.add(nums[i]);

            combineHelper(nums, len, i + 1, res, path);

            path.remove(path.size() - 1);
        }

    }

}

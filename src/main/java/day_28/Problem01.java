package day_28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/14
 * @description 子集II
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {1, 2, 2};

        subsetsWithDup(nums).forEach(System.out::println);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        ans.add(new ArrayList<>(path));

        int n = nums.length;

        for (int mask = 1; mask < (1 << n); mask++) {

            path.clear();

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && nums[i] == nums[i - 1] && (mask & (1 << (i - 1))) == 0) {
                        path.clear();
                        break;
                    }
                    path.add(nums[i]);
                }

            }

            if (!path.isEmpty()) {
                ans.add(new ArrayList<>(path));
            }
        }

        return ans;
    }

}

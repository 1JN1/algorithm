package day_138;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/5/15
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] nums = {3, 2, 3, 4, 2};
        System.out.println(Arrays.toString(distinctDifferenceArray(nums)));
    }

    public int[] distinctDifferenceArray(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            diff[i] = set.size();
        }

        set.clear();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            res[i] = set.size() - diff[i + 1];
        }

        return res;
    }

}

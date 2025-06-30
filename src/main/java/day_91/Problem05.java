package day_91;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

        System.out.println(threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int num = -nums[first];
            int second = first + 1, third = n - 1;

            while (second < third) {
                if (nums[second] + nums[third] == num) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    second++;
                    third--;
                    // 跳过重复的 nums[second]
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++;
                    }
                    // 跳过重复的 nums[third]
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--;
                    }
                } else if (nums[second] + nums[third] < num) {
                    second++;
                } else {
                    third--;
                }

            }

        }

        return res;
    }

}

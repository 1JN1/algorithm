package day_08;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/9/13
 * @description 四数之和
 **/
public class Problem02 {


    @Test
    public void test() {


        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));

    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4 || target < -Math.pow(10, 9) || target > Math.pow(10, 9)) {
            return res;
        }

        Arrays.sort(nums);


        for (int first = 0; first < nums.length - 3; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            // 转换成三数之和问题
            for (int second = first + 1; second < nums.length - 2; second++) {

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                int four = nums.length - 1;

                // 转换成两数之和问题

                long num = (long) target - nums[first] - nums[second];

                if (num > 2 * Math.pow(10, 9) && num < -2 * Math.pow(10, 9)) {
                    break;
                }

                // 双指针
                for (int third = second + 1; third < nums.length - 1; third++) {

                    if (third > second + 1 && nums[third] == nums[third - 1]) {
                        continue;
                    }

                    while (third < four && nums[third] + nums[four] > num) {
                        four--;
                    }

                    if (third == four) {
                        break;
                    }

                    if (nums[third] + nums[four] == num) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[third], nums[four]));
                    }

                }
            }

        }

        return res;
    }

}

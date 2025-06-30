package day_06;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/9/11
 * @description 三数之和
 **/
public class Problem02 {


    @Test
    public void test() {

        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));

    }

    public List<List<Integer>> threeSum(int[] nums) {


        List<List<Integer>> res = new ArrayList<>();


        Arrays.sort(nums);

        for (int first = 0; first < nums.length - 2; first++) {

            // 已经遍历过这个值
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int target = -nums[first];
            int third = nums.length - 1;

            // 双指针寻找两数之和等于target
            for (int second = first + 1; second < nums.length - 1; second++) {

                // 不遍历重复值
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                // 移动第三个指针
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (nums[second] + nums[third] == target) {
                    res.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }

        }


        return res;
    }

}

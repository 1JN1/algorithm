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
public class Problem07 {

    @Test
    public void test() {

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(nums, -294967296));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int first = 0; first < n; first++) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            for (int second = first + 1; second < n; second++) {

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                long num = (long) target -  nums[first] - nums[second];
                int third = second + 1, fourth = n - 1;

                while (third < fourth) {
                    long temp = (long) nums[third] + nums[fourth];
                    if (temp == num) {
                        list.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));

                        third++;
                        fourth--;

                        // 跳过重复元素
                        while (third < fourth && nums[third] == nums[third - 1]) {
                            third++;
                        }

                        while (third < fourth && nums[fourth] == nums[fourth + 1]) {
                            fourth--;
                        }

                    } else if (temp > num) {
                        fourth--;
                    } else {
                        third++;
                    }

                }

            }

        }

        return list;
    }

}

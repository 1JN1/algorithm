package day_07;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/9/12
 * @description 最接近的三数之和
 **/
public class Problem01 {


    @Test
    public void test() {


        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));

    }


    public int threeSumClosest(int[] nums, int target) {

        // 排序
        Arrays.sort(nums);

        // 最接近target的三数之和
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            // 避免遍历重复值
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 双指针
            int j = i + 1, k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    return target;
                }

                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }

                // 更新k
                if (sum > target) {
                    // 跳过重复值，减少遍历次数
                    int k0 = k - 1;
                    while (k0 > j && nums[k0] == nums[k]) {
                        k0--;
                    }
                    k = k0;
                    // 更新j
                } else {
                    // 跳过重复值，减少遍历次数
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        j0++;
                    }
                    j = j0;
                }

            }

        }

        return best;
    }

}

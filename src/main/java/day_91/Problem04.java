package day_91;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {4, 2, 3, 4};

        System.out.println(triangleNumber(nums));
    }


    public int triangleNumber(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < n; i++) {

            int k = i;

            for (int j = i + 1; j < n; j++) {

                while (k + 1 < n && nums[i] + nums[j] > nums[k + 1]) {
                    k++;
                }

                count += Math.max(0, k - j);

            }

        }


        return count;
    }

}

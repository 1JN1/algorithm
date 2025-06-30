package day_63;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 王文涛
 * @date 2024/11/30
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] nums = {-4, -2, 2, 4};
        int a = 1, b = 3, c = 5;

        System.out.println(Arrays.toString(sortTransformedArray2(nums, a, b, c)));

    }

    /**
     * 从对称轴向两边扩散
     *
     * @param nums
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        // 答案数组
        int[] result = new int[n];

        if (a == 0) {
            int idx = 0;
            for (int num : nums) {
                result[idx++] = f(a, b, c, num);
            }

            return result;
        }

        // 计算二次函数对称轴
        double aos = -b / 2.0 * a;

        // 找到nums中离对称轴最近的值
        double distance = Math.abs(nums[0] - aos);
        int left = 0;
        for (int i = 1; i < n; i++) {

            if (Math.abs(nums[i] - aos) < distance) {
                distance = Math.abs(nums[i] - aos);
                left = i;
            }

        }

        int right = left + 1;

        int k = a > 0 ? 0 : n - 1;
        // 沿着对称轴向两边扩散
        while (left >= 0 && right < n) {

            if (a > 0) {
                // 左指针对应的数距离对称轴更近
                if (Math.abs(nums[left] - aos) < Math.abs(nums[right] - aos)) {
                    result[k++] = f(a, b, c, nums[left--]);
                } else {
                    result[k++] = f(a, b, c, nums[right++]);
                }
            } else {
                // 左指针对应的数距离对称轴更近
                if (Math.abs(nums[left] - aos) < Math.abs(nums[right] - aos)) {
                    result[k--] = f(a, b, c, nums[left--]);
                } else {
                    result[k--] = f(a, b, c, nums[right++]);
                }
            }

        }

        while (left >= 0) {
            if (a > 0) {
                result[k++] = f(a, b, c, nums[left--]);
            } else {
                result[k--] = f(a, b, c, nums[left--]);
            }
        }

        while (right < n) {
            if (a > 0) {
                result[k++] = f(a, b, c, nums[right++]);
            } else {
                result[k--] = f(a, b, c, nums[right++]);
            }
        }


        return result;
    }

    /**
     * 从两边向中间扩散
     *
     * @param nums
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int[] sortTransformedArray2(int[] nums, int a, int b, int c) {


        int n = nums.length;
        int left = 0, right = n - 1;
        int k = a < 0 ? 0 : n - 1;

        int[] result = new int[n];

        while (left <= right) {

            int num1 = f(a, b, c, nums[left]), num2 = f(a, b, c, nums[right]);

            if (a < 0) {

                if (num1 < num2) {
                    result[k++] = num1;
                    left++;
                } else {
                    result[k++] = num2;
                    right--;
                }

            } else {

                if (num1 > num2) {
                    result[k--] = num1;
                    left++;
                } else {
                    result[k--] = num2;
                    right--;
                }

            }

        }

        return result;
    }

    private int f(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }

}

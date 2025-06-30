package day_56;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/21
 * @description 递增的三元子序列
 **/
public class Problem03 {

    @Test
    public void test() {


        System.out.println(increasingTriplet2(new int[]{9, 10, 5, 11, 10, 9, 8}));

    }

    public boolean increasingTriplet(int[] nums) {


        int n = nums.length;

        if (n < 3) {
            return false;
        }

        int[] leftMin = new int[n];
        leftMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > leftMin[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        int first = nums[0], second = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {

            int num = nums[i];

            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }

        }

        return false;
    }

}

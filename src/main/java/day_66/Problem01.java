package day_66;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/12/5
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {


        int[] nums = {1, 1, 7, 7, 9, 2, 5};

        System.out.println(wiggleMaxLength2(nums));

    }

    public int wiggleMaxLength(int[] nums) {


        int n = nums.length;

        if (n == 1) {
            return n;
        }

        boolean flag = nums[1] > nums[0];
        boolean flag1 = false;

        int i = 1;
        int count = 1;
        while (i < n) {

            while (i < n && nums[i] == nums[i - 1]) {
                i++;
                flag1 = true;
            }

            if (i == n) {
                break;
            }

            if (flag1) {
                flag = nums[i] > nums[i - 1];
            }

            flag1 = false;

            while (i < n && ((nums[i] > nums[i - 1]) != flag || nums[i] == nums[i - 1])) {
                i++;
            }

            if (i < n) {
                count++;
                flag = !flag;
            }

        }

        return count;
    }

    public int wiggleMaxLength2(int[] nums) {

        int n = nums.length;

        int pre = -1;
        int count = 1;
        for (int i = 1; i < n; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > nums[i - 1]) {

                if (pre == 1) {
                    continue;
                }

                pre = 1;
                count++;

            } else {

                if (pre == 0) {
                    continue;
                }

                pre = 0;
                count++;

            }

        }


        return count;
    }

}

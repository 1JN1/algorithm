package day_25;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/10/11
 * @description 颜色分类
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] nums = new int[]{
                2, 0, 2, 1, 1, 0
        };

        sortColors2(nums);

        System.out.println(Arrays.toString(nums));


    }

    public void sortColors(int[] nums) {

        // 扫描数组中三种颜色分别出现多少次
        int[] count = new int[3];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int idx = 0;

        for (int i = 0; i < count.length; i++) {

            while (count[i]-- > 0) {
                nums[idx++] = i;
            }

        }

    }

    public void sortColors2(int[] nums) {

        int p0 = 0, p1 = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {

                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;

            } else if (nums[i] == 0) {

                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;

                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }

                p0++;
                p1++;

            }

        }

    }

}

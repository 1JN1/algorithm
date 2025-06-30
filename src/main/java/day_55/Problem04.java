package day_55;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/20
 * @description 摆动排序II
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] nums = {4, 5, 5, 6};

        wiggleSort(nums);

        System.out.println(Arrays.toString(nums));

    }

    public void wiggleSort(int[] nums) {

        int[] temp = nums.clone();

        Arrays.sort(temp);

        int len = (nums.length + 1) / 2;

        for (int i = 0, j = len - 1, k = nums.length - 1; i < nums.length; i += 2, j--, k--) {

            nums[i] = temp[j];

            if (i + 1 < nums.length) {
                nums[i + 1] = temp[k];
            }

        }

    }

}

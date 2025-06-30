package day_11;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/16
 * @description 删除有序数组中的重复项
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] nums = {1, 1, 2, 2, 3};

        System.out.println(removeDuplicates(nums));


    }

    public int removeDuplicates(int[] nums) {

        // 处理后数组长度
        int len = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[len - 1]) {
                nums[len++] = nums[i];
            }

        }

        return len;
    }

}

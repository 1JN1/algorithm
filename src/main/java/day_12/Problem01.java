package day_12;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/17
 * @description 移除元素
 **/

public class Problem01 {

    @Test
    public void test() {

        System.out.println(removeElement(new int[]{1, 1, 2, 1, 3}, 1));

    }


    public int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[k++] = nums[i];
            }

        }

        return k;
    }

}

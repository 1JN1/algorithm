package day_26;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/12
 * @description 删除有序数组中的重复项
 **/
public class Problem04 {

    @Test
    public void test() {

        System.out.println(removeDuplicates2(new int[]{1, 1, 1, 2, 2, 3}));

    }

    public int removeDuplicates(int[] nums) {

        int num = nums[0];
        int len = 0;
        int k = 0;
        int i = 0;

        while (i < nums.length) {

            while (i < nums.length && nums[i] == num) {
                i++;
                len++;
            }

            len = Math.min(len, 2);

            while (len-- > 0) {
                nums[k++] = num;
            }

            if (i < nums.length) {
                num = nums[i];
                len = 0;
            }

        }

        return k;
    }

    public int removeDuplicates2(int[] nums) {

        int i = 2, k = 2;

        while (i < nums.length) {

            if (nums[k - 2] != nums[i]) {
                nums[k++] = nums[i];
            }
            i++;
        }

        return k;
    }

}

package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem02 {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < n; i++) {
            nums[i] = 0;
        }

    }
}

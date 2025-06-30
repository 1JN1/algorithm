package day_83;

/**
 * @author 王文涛
 * @date 2025/2/9
 * @description
 **/
public class Problem04 {
    public void sortColors(int[] nums) {

        int red = 0, white = 0, blue = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                red++;
            } else if (nums[i] == 1) {
                white++;
            } else {
                blue++;
            }
        }

        int k = 0;
        for (int i = 0; i < red; i++) {
            nums[k++] = 0;
        }
        for (int i = 0; i < white; i++) {
            nums[k++] = 1;
        }
        for (int i = 0; i < blue; i++) {
            nums[k++] = 2;
        }

    }
}

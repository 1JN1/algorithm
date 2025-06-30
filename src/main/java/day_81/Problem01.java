package day_81;

/**
 * @author 王文涛
 * @date 2025/2/5
 * @description
 **/
public class Problem01 {


    public void rotate(int[] nums, int k) {

        int n = nums.length - 1;

        k = k % nums.length;

        reverse(nums, 0, n - k);
        reverse(nums, n - k + 1, n);
        reverse(nums, 0, n);

    }


    public void reverse(int[] nums, int begin, int end) {

        int len = end - begin + 1;

        for (int i = 0; i < len / 2; i++) {
            int temp = nums[begin + i];
            nums[begin + i] = nums[end - i];
            nums[end - i] = temp;
        }

    }

}

package day_100;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/5
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] numbers = {0, 0, 3, 4};
        int target = 0;

        int[] ans = twoSum(numbers, target);

        System.out.println(ans[0] + " " + ans[1]);

    }

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int left = 0, right = n - 1;

        int[] ans = new int[2];

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }

        return ans;
    }

}

package day_90;

/**
 * @author 王文涛
 * @date 2025/2/18
 * @description
 **/
public class Problem04 {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }

        }

        return new int[]{-1, -1};
    }

}

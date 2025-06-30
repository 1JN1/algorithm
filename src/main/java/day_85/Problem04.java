package day_85;

/**
 * @author 王文涛
 * @date 2025/2/11
 * @description
 **/
public class Problem04 {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        int[] result = new int[2];

        int left = 0, right = n - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }

        return result;
    }
}

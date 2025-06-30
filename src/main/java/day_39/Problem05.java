package day_39;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2024/11/4
 * @description 两数之和II-输入有序数组
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(Arrays.toString(twoSum(numbers, 7)));

    }

    public int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];

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

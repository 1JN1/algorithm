package day_137;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/14
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 左边选偶数个的方案数
            int leftEven = (i + 2) / 2;
            // 左边选奇数个的方案数
            int leftOdd = (i + 1) / 2;
            // 右边选偶数个的方案数
            int rightEven = (n - i + 1) / 2;
            // 右边选奇数个的方案数
            int rightOdd = (n - i) / 2;
            int count = leftEven * rightEven + leftOdd * rightOdd;
            sum += arr[i] * count;
        }
        return sum;
    }
}

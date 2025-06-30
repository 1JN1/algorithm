package day_89;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/17
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {

        System.out.println(totalDigits(2));
    }

    public int findNthDigit(int n) {


        int low = 1, high = 9;
        // 判断第n个数在哪一位
        while (low < high) {

            int mid = low + (high - low) / 2;
            if (totalDigits(mid) < n) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }

        int d = low;
        int preIndex = totalDigits(d - 1);
        // 还剩多少位
        int index = n - preIndex - 1;
        int start = (int) Math.pow(10, d - 1);
        // 第n位具体在那个数上
        int num = start + index / d;
        // 在num的第几位上
        int digitIndex = index % d;
        int digit = (num / (int) Math.pow(10, d - digitIndex - 1)) % 10;

        return digit;
    }

    public int totalDigits(int length) {

        int curLength = 1, count = 0;
        while (curLength <= length) {

            count += curLength * 9 * (int) Math.pow(10, curLength - 1);
            curLength++;

        }

        return count;
    }

}

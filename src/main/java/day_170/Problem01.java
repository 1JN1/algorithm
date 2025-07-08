package day_170;

/**
 * @author 王文涛
 * @date 2025/7/8
 * @description
 **/
public class Problem01 {

    public int countDigits(int num) {

        // 统计num中每一位的数字出现的次数
        int[] count = new int[10];

        int temp = num;
        while (temp != 0) {
            count[temp % 10]++;
            temp /= 10;
        }

        // 统计每一位是否可以整除num
        int res = 0;
        for (int i = 1; i < 10; i++) {
            if (num % i == 0) {
                res += count[i];
            }
        }

        return res;
    }

}

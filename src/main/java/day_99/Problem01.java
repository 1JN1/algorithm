package day_99;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/3/4
 * @description
 **/
public class Problem01 {


    @Test
    public void test() {

        int low = 10;
        int high = 1000000000;

        System.out.println(sequentialDigits(low, high));

    }

    public List<Integer> sequentialDigits(int low, int high) {

        // 判断low的位数
        int lowDigit = (int) Math.log10(low) + 1;
        // 判断high的位数
        int highDigit = (int) Math.log10(high) + 1;

        List<Integer> ans = new ArrayList<>();

        while (lowDigit <= highDigit) {

            for (int i = 1; i <= 9; i++) {

                int num = 0;
                boolean flag = false;
                for (int j = 0; j < lowDigit; j++) {
                    if ((i + j) > 9) {
                        flag = true;
                        break;
                    }
                    num = num * 10 + i + j;
                }

                if (num > high) {
                    return ans;
                }

                if (!flag && num >= low) {
                    ans.add(num);
                }

            }

            lowDigit++;
        }

        return ans;
    }

}

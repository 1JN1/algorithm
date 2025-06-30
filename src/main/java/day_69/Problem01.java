package day_69;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/1/14
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {


        System.out.println(lexicalOrder(100));

    }

    public List<Integer> lexicalOrder(int n) {

        List<Integer> ans = new ArrayList<>();
        int number = 1;
        // 一共要输出n个数
        for (int i = 0; i < n; i++) {

            ans.add(number);

            if (number * 10 <= n) {
                number *= 10;
            } else {

                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }

                number++;

            }

        }

        return ans;
    }

}

package day_133;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/5/10
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        System.out.println(goodDaysToRobBank(security, time));
    }


    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];


        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
            if (security[n - i - 1] <= security[n - i]) {
                right[n - i - 1] = right[n - i] + 1;
            } else {
                right[n - i - 1] = 0;
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = time; i < n - time; i++) {
            if (left[i] >= time && right[i] >= time) {
                res.add(i);
            }
        }

        return res;
    }
}

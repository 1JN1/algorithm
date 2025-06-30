package day_129;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/3
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] answers = {10,10,10};

        System.out.println(numRabbits(answers));

    }

    public int numRabbits(int[] answers) {

        int[] count = new int[1001];

        for (int answer : answers) {
            count[answer]++;
        }

        int ans = 0;
        for (int i = 0; i < 1001; i++) {
            if (count[i] != 0) {

                int num = (count[i] + i) / (i + 1);
                ans += num * (i + 1);

            }
        }

        return ans;
    }

}

package day_178;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/29 11:13
 */
public class Problem05 {

    @Test
    public void test(){

        System.out.println(Arrays.toString(closestDivisors(999)));

    }

    public int[] closestDivisors(int num) {

        int[] divisor1 = helper(num + 1);
        int[] divisor2 = helper(num + 2);

        int distance1 = Math.abs(divisor1[0] - divisor1[1]);
        int distance2 = Math.abs(divisor2[0] - divisor2[1]);

        return distance1 < distance2 ? divisor1 : divisor2;
    }

    public int[] helper(int num) {

        int sqrt = (int) Math.sqrt(num);

        for (int i = sqrt; i >= 1; i--) {

            if (num % i == 0) {
                return new int[]{i, num / i};
            }

        }

        return new int[]{0, 0};
    }

}

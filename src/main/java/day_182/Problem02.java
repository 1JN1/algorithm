package day_182;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/6 9:41
 */
public class Problem02 {

    @Test
    public void test() {
        System.out.println(minFlips(2, 6, 5));
        System.out.println(minFlips(4, 2, 7));
        System.out.println(minFlips(1, 2, 3));
    }

    private static final int MAX_BIT = 32;

    public int minFlips(int a, int b, int c) {

        int count = 0;

        for (int i = MAX_BIT - 1; i >= 0; i--){
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 0){
                count += bitA + bitB;
            }else{
                if (bitA == 0 && bitB == 0) {
                    count++;
                }
            }
        }

        return count;
    }

}

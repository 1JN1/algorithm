package day_177;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/27 9:09
 */
public class Problem01 {

    public int minimumBoxes(int[] apple, int[] capacity) {


        int totalApple = Arrays.stream(apple).sum();

        Arrays.sort(capacity);

        // 遍历list，只到容量大于等于totalApple
        int sum = 0;
        int count = 0;
        int m = capacity.length;

        for (int i = m - 1; i >= 0; i--) {
            sum += capacity[i];
            count++;
            if (sum >= totalApple) {
                break;
            }
        }

        return count;
    }

}

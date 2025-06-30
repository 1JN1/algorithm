package day_78;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 王文涛
 * @date 2025/1/26
 * @description 使用最少数量的箭引爆气球
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] points = {
                {-2147483648, 2147483647}
        };

        System.out.println(findMinArrowShots(points));

    }

    public int findMinArrowShots(int[][] points) {

        // 按照右端点进行升序排序
        Arrays.sort(points, Comparator.comparingInt((int[] point) -> point[1]));
        int count = 1;
        int right = points[0][1];
        int n = points.length;
        for (int i = 1; i < n; i++) {

            if (right < points[i][0]) {
                count++;
                right = points[i][1];
            }

        }

        return count;
    }

}

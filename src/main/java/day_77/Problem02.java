package day_77;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2025/1/24
 * @description 回旋镖的数量
 **/
public class Problem02 {

    @Test
    public void test() {

        int[][] points = {
                {1, 1}, {2, 2}, {3, 3}
        };

        System.out.println(numberOfBoomerangs(points));

    }

    public int numberOfBoomerangs(int[][] points) {

        Map<Double, Integer> map = new HashMap<>();

        int n = points.length;

        if (n == 1) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                double distance = distance(points[i], points[j]);

                if (map.containsKey(distance)) {
                    map.put(distance, map.get(distance) + 1);
                    ans += map.get(distance);
                } else {
                    map.put(distance, 0);
                }

            }
            map.clear();
        }

        return ans * 2;
    }

    public double distance(int[] point1, int[] point2) {

        double v = Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2);

        return Math.sqrt(v);
    }

}

package day_152;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/6/1
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int[][] rectangles = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points = {{1, 3}, {3, 1}};
        System.out.println(Arrays.toString(countRectangles(rectangles, points)));
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {

        int[] ans = new int[points.length];

        // 统计相同纵坐标包含的横坐标
        Map<Integer, List<Integer>> map = new HashMap<>(points.length);

        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        // 对横坐标排序
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int idx = 0;
        // 遍历所有店
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int count = 0;
            // 遍历所有可能的纵坐标
            for (int h = 100; h > 0; h--) {

                if (h < y) {
                    break;
                }

                if (!map.containsKey(h)) {
                    continue;
                }

                List<Integer> list1 = map.get(h);
                count += binarySearch(list1, x);
            }

            ans[idx++] = count;
        }

        return ans;
    }

    /**
     * 统计横坐标大于等于target的数量
     *
     * @param list
     * @param target
     * @return
     */
    private int binarySearch(List<Integer> list, int target) {

        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return list.get(right) >= target ? list.size() - right : 0;
    }

}

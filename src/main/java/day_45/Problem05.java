package day_45;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/10
 * @description 矩形面积
 **/
public class Problem05 {

    @Test
    public void test() {

        int ax1 = -2;
        int ay1 = -2;
        int ax2 = 2;
        int ay2 = 2;
        int bx1 = -2;
        int by1 = -2;
        int bx2 = 2;
        int by2 = 2;

        System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));

    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int sum = 0;

        // 计算总面积

        sum += (ax2 - ax1) * (ay2 - ay1);
        sum += (bx2 - bx1) * (by2 - by1);

        // 减去重叠面积

        int x = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int y = Math.min(ay2, by2) - Math.max(ay1, by1);
        if (x > 0 && y > 0) {
            sum -= x * y;
        }

        return sum;
    }

}

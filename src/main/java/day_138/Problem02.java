package day_138;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/15
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        System.out.println(checkOverlap(1, 0, 0, 1, -1, 3, 1));
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

        // 找出矩形到圆心最近的一个点的坐标
        int x = xCenter;
        int y = yCenter;

        if (xCenter < x1){
            x = x1;
        }
        if (xCenter > x2){
            x = x2;
        }
        if (yCenter < y1){
            y = y1;
        }
        if (yCenter > y2){
            y = y2;
        }

        return Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2) <= Math.pow(radius, 2);
    }
}

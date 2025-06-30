package day_04;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/9
 * @description 盛最多水的容器
 **/
public class Problem02 {

    @Test
    public void test() {


    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;

        while (l < r) {

            int area = Math.min(height[l], height[r]) * (r - l);

            ans = Math.max(ans, area);

            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }

        }

        return ans;
    }

}

package day_91;

/**
 * @author 王文涛
 * @date 2025/2/20
 * @description
 **/
public class Problem03 {

    public int maxArea(int[] height) {

        int max = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {

            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);

            // 移动较低的柱子
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return max;
    }

}

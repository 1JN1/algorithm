package day_92;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/2/21
 * @description
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] height = {4, 2, 3};

        System.out.println(trap(height));

    }


    public int trap(int[] height) {

        int n = height.length;
        int count = 0;

        int i = 0;

        while (i < n - 1) {

            // 找到第一个比height[i]大的元素
            int j = i + 1;
            int idx = j;
            int num = Math.abs(height[i] - height[j]);
            while (j < n && height[j] < height[i]) {
                j++;
                if (j < n && Math.abs(height[j] - height[i]) <= num) {
                    num = Math.abs(height[j] - height[i]);
                    idx = j;
                }
            }

            if (j == n) {
                j = idx;
            }

            // 取两端较小值
            int minHeight = Math.min(height[i], height[j]);
            for (int k = i + 1; k < j; k++) {
                count += minHeight - height[k];
            }

            i = j;

        }


        return count;
    }

    public int trap2(int[] height) {

        int n = height.length;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;

        while (left <= right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (height[left] < height[right]) {
                count += leftMax - height[left];
                left++;
            } else {
                count += rightMax - height[right];
                right--;
            }

        }

        return count;
    }

}

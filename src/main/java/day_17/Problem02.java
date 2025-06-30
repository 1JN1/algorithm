package day_17;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/9/30
 * @description 跳跃游戏II
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(jump2(new int[]{2, 3, 1, 1, 4}));

    }

    public int jump(int[] nums) {

        int position = nums.length - 1;
        int steps = 0;

        while (position > 0) {

            for (int i = 0; i < position; i++) {

                if (nums[i] + i >= position) {
                    position = i;
                    steps += 1;
                }

            }
        }

        return steps;
    }

    public int jump2(int[] nums) {

        // 跳跃的步数
        int steps = 0;
        // 边界
        int end = 0;
        // 边界内能跳跃到的最大位置
        int maxPosition = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            maxPosition = Math.max(maxPosition, i + nums[i]);

            // 当扫描到边界位置
            if (i == end) {
                steps += 1;
                // 更新边界
                end = maxPosition;
            }

            // 边界已经到达目标点
            if (end == nums.length - 1) {
                break;
            }
        }

        return steps;
    }

}

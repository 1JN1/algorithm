package day_21;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/5
 * @description 跳跃游戏
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(canJump(new int[]{0}));

    }

    public boolean canJump(int[] nums) {

        // 可以跳跃到的最大距离
        int maxDistance = 0;
        // 右边界
        int right = 0;


        for (int i = 0; i < nums.length; i++) {

            maxDistance = Math.max(maxDistance, i + nums[i]);

            if (i == right) {
                right = maxDistance;
            }

            if (right >= nums.length - 1) {
                return true;
            }

            // 没有向前跳跃
            if (i == right) {
                return false;
            }
        }

        return false;
    }

}

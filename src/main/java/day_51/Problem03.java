package day_51;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/16
 * @description 寻找重复数
 **/
public class Problem03 {

    @Test
    public void test() {

        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 2}));

    }

    public int findDuplicate(int[] nums) {


        int l = 1, r = nums.length - 1, ans = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                l = mid + 1;
            } else {
                ans = mid;
                r = mid - 1;
            }

        }

        return ans;
    }

    public int findDuplicate2(int[] nums) {

        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 找环的起点
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}

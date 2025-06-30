package day_88;

/**
 * @author 王文涛
 * @date 2025/2/15
 * @description
 **/
public class Problem02 {

    public int findDuplicate(int[] nums) {


        int slow = 0, fast = 0;
        do {

            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

}

package day_183;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/11 9:40
 */
public class Problem02 {

    public boolean divideArray(int[] nums) {

        // 统计每个数字出现的次数
        int[] count = new int[501];
        for (int num : nums) {
            count[num]++;
        }

        // 检查每个数字的出现次数是否为偶数
        for (int c : count) {
            if (c % 2 != 0) {
                return false;
            }
        }

        return true;
    }

}

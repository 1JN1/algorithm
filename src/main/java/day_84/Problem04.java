package day_84;

/**
 * @author 王文涛
 * @date 2025/2/10
 * @description
 **/
public class Problem04 {
    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}

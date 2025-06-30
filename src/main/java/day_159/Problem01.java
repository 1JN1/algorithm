package day_159;

/**
 * @author 王文涛
 * @date 2025/6/16
 * @description
 **/
public class Problem01 {

    public boolean isPossibleToSplit(int[] nums) {

        // 统计有没有元素的个数超过两个
        int[] count = new int[101];

        for (int num : nums){
            count[num]++;
            if (count[num] > 2) {
                return false;
            }
        }

        return true;
    }

}

package day_160;

/**
 * @author 王文涛
 * @date 2025/6/19
 * @description
 **/
public class Problem01 {

    public int minCostToMoveChips(int[] position) {

        // 统计奇数和偶数的个数
        int odd = 0;
        int even = 0;

        for (int num : position) {
            if (num % 2 == 1) {
                odd++;
            } else {
                even++;
            }
        }

        return Math.min(odd, even);
    }

}

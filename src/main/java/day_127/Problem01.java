package day_127;

/**
 * @author 王文涛
 * @date 2025/4/29
 * @description
 **/
public class Problem01 {

    public int totalMoney(int n) {

        // 共计多少周
        int weekNum = n / 7;
        // 最后一周有多少天
        int lastWeekDay = n % 7;

        int total = 0;

        total += 28 * weekNum + ((weekNum - 1) * weekNum / 2) * 7;

        total += (weekNum * 2 + 1 + lastWeekDay) * lastWeekDay / 2;

        return total;
    }

}

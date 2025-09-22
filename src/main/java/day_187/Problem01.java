package day_187;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/9/22 19:37
 */
public class Problem01 {


    // 每个月天数（非闰年）
    private static final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // 转换成一年中的第几天
        int aliceBegin = toDayOfYear(arriveAlice);
        int aliceEnd = toDayOfYear(leaveAlice);
        int bobBegin = toDayOfYear(arriveBob);
        int bobEnd = toDayOfYear(leaveBob);

        // 交集区间
        int begin = Math.max(aliceBegin, bobBegin);
        int end = Math.min(aliceEnd, bobEnd);

        // 如果没有交集返回 0
        return Math.max(0, end - begin + 1);
    }

    // 将 "MM-DD" 转换为一年中的第几天
    private int toDayOfYear(String date) {
        String[] split = date.split("-");
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);

        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += daysOfMonth[i];
        }
        return sum + day;
    }

    @Test
    public void test(){
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19")); // 3
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31")); // 0
        System.out.println(countDaysTogether("09-01", "09-30", "09-21", "10-10")); // 10
    }

}

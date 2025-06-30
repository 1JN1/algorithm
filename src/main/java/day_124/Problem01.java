package day_124;

/**
 * @author 王文涛
 * @date 2025/4/22
 * @description
 **/
public class Problem01 {

    public int getMinimumTime(int[] time, int[][] fruits, int limit) {

        int minTime = 0;


        for (int[] fruit : fruits) {

            int type = fruit[0];
            int num = fruit[1];

            // 需要采集多少次
            int count = (num + limit - 1) / limit;
            minTime += count * time[type];
        }

        return minTime;
    }

}

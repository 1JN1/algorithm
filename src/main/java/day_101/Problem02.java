package day_101;

/**
 * @author 王文涛
 * @date 2025/3/7
 * @description
 **/
public class Problem02 {

    public int minFlipsMonoIncr(String s) {


        int dp0 = 0, dp1 = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {

            char c = s.charAt(i);
            int newDp0 = dp0, newDp1 = Math.min(dp0, dp1);

            if (c == '1') {
                newDp0++;
            } else {
                newDp1++;
            }

            dp0 = newDp0;
            dp1 = newDp1;
        }


        return Math.min(dp0, dp1);
    }

}

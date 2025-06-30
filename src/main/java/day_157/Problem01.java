package day_157;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/6/10
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        int n = 2;
        int m = 3;
        int[] hBars = {2, 3};
        int[] vBars = {2, 3, 4};
        System.out.println(maximizeSquareHoleArea(n, m, hBars, vBars));
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        Arrays.sort(hBars);
        Arrays.sort(vBars);

        // 找出hBars中最大连续的长度
        int h = getMaxSequenceLen(hBars);

        // 找出vBars中最大连续的长度
        int v = getMaxSequenceLen(vBars);

        int len = Math.min(h, v);

        return (len + 1) * (len + 1);
    }

    private int getMaxSequenceLen(int[] arr) {
        int idx = 0;
        int ans = 0;
        while (idx < arr.length) {
            int curLen = 1;
            while (idx < arr.length - 1 && arr[idx] == arr[idx + 1] - 1) {
                curLen++;
                idx++;
            }
            ans = Math.max(ans, curLen);
            idx++;
        }

        return ans;
    }

}

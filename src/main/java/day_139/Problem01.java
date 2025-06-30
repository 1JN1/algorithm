package day_139;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/5/16
 * @description
 **/
public class Problem01 {

    public int[] threeEqualParts(int[] arr) {

        // 求出1的个数
        int oneCount = Arrays.stream(arr).sum();

        if (oneCount % 3 != 0) {
            return new int[]{-1, -1};
        }

        if (oneCount == 0) {
            return new int[]{0, 2};
        }

        int partial = oneCount / 3;

        int n = arr.length;
        int first = 0, second = 0, third = 0, cur = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                // 遇到第一个1
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == partial * 2) {
                    third = i;
                }
                cur++;
            }
        }

        int len = n - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < n) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }

        return new int[]{-1, -1};
    }
}

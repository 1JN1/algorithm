package day_50;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/15
 * @description 第一个错误的版本
 **/
public class Problem03 {

    @Test
    public void test() {

    }

    public boolean isBadVersion(int version) {
        return version >= 4;
    }

    public int firstBadVersion(int n) {

        int left = 1, right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return right + 1;
    }

}

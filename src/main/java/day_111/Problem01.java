package day_111;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/3/19
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] arr = {0, 3, 2, 1};

        System.out.println(validMountainArray(arr));

    }

    public boolean validMountainArray(int[] arr) {

        int len = arr.length;

        if (len < 3) {
            return false;
        }

        int i = 0;
        while (i < len - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == len - 1) {
            return false;
        }

        while (i < len - 1 && arr[i + 1] < arr[i]) {
            i++;
        }

        return i == len - 1;
    }

}

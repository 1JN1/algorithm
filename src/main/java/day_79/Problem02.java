package day_79;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 王文涛
 * @date 2025/2/1
 * @description
 **/
public class Problem02 {


    @Test
    public void test() {

        int[] g = {1, 2, 3};
        int[] s = {1, 2, 1};

        System.out.println(findContentChildren(g, s));

    }

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int m = g.length, n = s.length;
        int count = 0;
        while (j < n && i < m) {

            if (s[j] >= g[i]) {
                count++;
                i++;
            }

            j++;
        }

        return count;
    }

}

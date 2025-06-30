package day_40;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/5
 * @description Excel表列序号
 **/
public class Problem04 {

    @Test
    public void test() {

    }

    public int titleToNumber(String columnTitle) {

        int ans = 0, len = columnTitle.length();

        for (int i = 0; i < len; i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;

            ans = ans * 26 + num;

        }

        return ans;
    }

}

package day_151;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/31
 * @description
 **/
public class Problem01 {

    public int minSwaps(String s) {

        int ans = 0;
        int c = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                ans++;
                c++;
            }
        }

        return ans;
    }
}

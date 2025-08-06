package day_182;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/6 9:48
 */
public class Problem03 {

    public int minimumOneBitOperations(int n) {
        int ans = 0;
        while (n != 0) {
            ans ^= n;
            n >>= 1;
        }
        return ans;
    }
}

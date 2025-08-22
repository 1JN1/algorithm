package day_186;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/8/19 9:41
 */
public class Problem01 {

    @Test
    public void test() {
        int[] bits = {1, 0, 0};
        System.out.println(isOneBitCharacter(bits)); // true

        bits = new int[]{1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits)); // false
    }

    public boolean isOneBitCharacter(int[] bits) {

        int len = bits.length;

        if (len == 1) {
            return bits[0] == 0;
        }

        int idx = 0;

        while (idx < len - 1) {
            if (bits[idx] == 0) {
                idx++;
            } else {
                idx += 2;
            }
        }

        // 如果 idx 恰好指向最后一个元素，则说明是一个一位字符
        return idx == len - 1;
    }

}

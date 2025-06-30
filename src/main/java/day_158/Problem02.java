package day_158;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/11
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int N = 1024;
        int M = 19;
        int i = 2;
        int j = 6;
        System.out.println(insertBits(N, M, i, j));
    }

    public int insertBits(int N, int M, int i, int j) {

        for (int k = i; k <= j; k++) {
            // 清除 N 的第 k 位
            int mask = 1 << k;
            N &= ~mask;

            // 获取 M 的第 (k - i) 位（假设 M 的位从低到高对齐到 i~j）
            int mBit = (M >> (k - i)) & 1;

            // 设置 N 的第 k 位为 mBit
            N |= (mBit << k);
        }

        return N;
    }

    public int insertBits2(int N, int M, int i, int j) {
        // 创建掩码：i~j 位为 0，其余为 1
        int mask = ~(((1 << (j - i + 1)) - 1) << i);
        // 清除 N 的 i~j 位
        N &= mask;
        // 将 M 的位对齐到 i，并插入到 N
        N |= (M << i);
        return N;
    }


}

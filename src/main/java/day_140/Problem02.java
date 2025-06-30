package day_140;

/**
 * @author 王文涛
 * @date 2025/5/18
 * @description
 **/
public class Problem02 {
    public int bitwiseComplement(int n) {

        // 求出n的二进制
        String binary = Integer.toBinaryString(n);

        // 遍历二进制，如果当前位是0，则将其置为1，否则置为0
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                binary = binary.substring(0, i) + '1' + binary.substring(i + 1);
            } else {
                binary = binary.substring(0, i) + '0' + binary.substring(i + 1);
            }
        }

        return Integer.parseInt(binary, 2);
    }

    public int bitwiseComplement2(int n) {

        // 初始掩码
        int mask = 1;

        // 计算小于n的最大掩码
        while (mask < n) {
            mask = (mask << 1) | 1;
        }

        return n ^ mask;
    }
}

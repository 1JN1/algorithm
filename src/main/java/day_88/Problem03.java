package day_88;

/**
 * @author 王文涛
 * @date 2025/2/15
 * @description
 **/
public class Problem03 {


    public double quickMul(double x, long n) {

        double ans = 1.0;
        double xContribute = x;

        while (n > 0) {

            // 二进制最低位为1
            if (n % 2 == 1) {
                ans *= xContribute;
            }

            xContribute *= xContribute;
            n /= 2;
        }

        return ans;
    }

    public double myPow(double x, int n) {

        long N = n;

        return n >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

}

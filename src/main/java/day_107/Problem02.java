package day_107;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/3/14
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        int[] nums = {78756,82259,82272,50895,19786};
        System.out.println(sumFourDivisors(nums));
    }

    static final int N = 100000, C3 = 46;

    public int sumFourDivisors(int[] nums) {


        // 求出1到N的所有质数
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
            for (int j = i + i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        // 求出所有因子数目为4的数的因子之和
        Map<Integer, Integer> map = new HashMap<>(primes.size());
        for (int prime : primes) {
            if (prime <= C3) {
                map.put(prime * prime * prime, 1 + prime + prime * prime + prime * prime * prime);
            }
        }

        int n = primes.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p1 = primes.get(i), p2 = primes.get(j);
                if (p1 <= N / p2) {
                    map.put(p1 * p2, 1 + p1 + p2 + p1 * p2);
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                ans += map.get(num);
            }
        }

        return ans;
    }

}

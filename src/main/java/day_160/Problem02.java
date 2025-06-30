package day_160;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 王文涛
 * @date 2025/6/19
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        String s = "12234";
        System.out.println(sumOfLargestPrimes(s));
    }

    private static final int MX = 100_000;
    private static final boolean[] np = new boolean[MX + 1];
    private static final List<Integer> primeNumbers = new ArrayList<>();
    private static boolean initialized = false;

    private void init() {
        if (initialized) {
            return;
        }
        initialized = true;

        np[0] = np[1] = true;
        for (int i = 2; i <= MX; i++) {
            if (!np[i]) {
                primeNumbers.add(i);
                // 避免溢出的写法
                for (int j = i; j <= MX / i; j++) {
                    np[i * j] = true;
                }
            }
        }
    }

    private boolean isPrime(long n) {
        if (n <= MX) {
            return !np[(int) n];
        }
        for (int p : primeNumbers) {
            if (p > n / p) {
                break;
            }
            if (n % p == 0) {
                return false;
            }
        }
        return true;
    }

    public long sumOfLargestPrimes(String S) {
        init();
        char[] s = S.toCharArray();
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < s.length; i++) {
            long x = 0;
            for (int j = i; j < s.length; j++) {
                x = x * 10 + (s[j] - '0');
                if (isPrime(x)) {
                    set.add(x);
                }
            }
        }

        return set.descendingSet()
                .stream()
                .limit(3)
                .mapToLong(Long::longValue)
                .sum();
    }
}

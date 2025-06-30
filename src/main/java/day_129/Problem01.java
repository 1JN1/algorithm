package day_129;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/5/3
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});

        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }

    class Bank {

        private long[] balance;
        private int n;

        public Bank(long[] balance) {
            this.balance = balance;
            this.n = balance.length;
        }

        private boolean check(int account) {
            return account >= 1 && account <= n;
        }

        private boolean checkMoney(int account, long money) {
            return balance[account - 1] >= money;
        }

        public boolean transfer(int account1, int account2, long money) {

            if (!check(account1) || !check(account2)) {
                return false;
            }

            if (!checkMoney(account1, money)) {
                return false;
            }

            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;

            return true;
        }

        public boolean deposit(int account, long money) {

            if (!check(account)) {
                return false;
            }

            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {

            if (!check(account) || !checkMoney(account, money)) {
                return false;
            }

            balance[account - 1] -= money;
            return true;
        }
    }
}

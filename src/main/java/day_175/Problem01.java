package day_175;

import org.junit.Test;

/**
 * @author 王文涛
 * @version 1.0
 * @since 2025/7/23 8:57
 */
public class Problem01 {

    @Test
    public void test() {

        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s, goal));

    }

    public boolean rotateString(String s, String goal) {

        int len = s.length();

        for (int i = 0; i < len; i++) {

            // 将首字母放到最后
            s = s.substring(1, len) + s.charAt(0);

            if (s.equals(goal)) {
                return true;
            }

        }

        return false;
    }

    public boolean rotateString1(String s, String goal) {
        // 提前判断长度
        if (s.length() != goal.length()) {
            return false;
        }

        // 如果goal是s的旋转，那么goal一定是s+s的子串
        return (s + s).contains(goal);
    }

}

package day_48;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/11/13
 * @description 位运算表达式设计优先级
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(diffWaysToCompute("2*3-4*5"));

    }

    static final int ADD = -1;
    static final int SUBTRACT = -2;
    static final int MULTIPLY = -3;

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> ops = new ArrayList<>();

        // 取出所有的操作数与运算符
        for (int i = 0; i < expression.length(); ) {

            if (!Character.isDigit(expression.charAt(i))) {

                if (expression.charAt(i) == '+') {
                    ops.add(ADD);
                } else if (expression.charAt(i) == '-') {
                    ops.add(SUBTRACT);
                } else {
                    ops.add(MULTIPLY);
                }

                i++;
            } else {

                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + expression.charAt(i) - '0';
                    i++;
                }

                ops.add(num);
            }

        }

        // dp[i][j] 表示ops从i到j所有的运算符与操作数不同优先级计算的结果
        List<Integer>[][] dp = new List[ops.size()][ops.size()];
        for (int i = 0; i < ops.size(); i++) {
            for (int j = 0; j < ops.size(); j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        return dfs(dp, 0, ops.size() - 1, ops);
    }

    private List<Integer> dfs(List<Integer>[][] dp, int l, int r, List<Integer> ops) {

        if (dp[l][r].isEmpty()) {

            if (l == r) {
                dp[l][r].add(ops.get(l));
            } else {

                for (int i = l; i < r; i += 2) {

                    List<Integer> left = dfs(dp, l, i, ops);
                    List<Integer> right = dfs(dp, i + 2, r, ops);

                    for (int num1 : left) {
                        for (int num2 : right) {

                            if (ops.get(i + 1) == ADD) {
                                dp[l][r].add(num1 + num2);
                            } else if (ops.get(i + 1) == SUBTRACT) {
                                dp[l][r].add(num1 - num2);
                            } else {
                                dp[l][r].add(num1 * num2);
                            }

                        }
                    }

                }

            }

        }

        return dp[l][r];
    }


}

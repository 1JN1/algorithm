package day_164;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2025/6/28
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {


        List<String> ans = new ArrayList<String>();


        backtrack(ans, "", 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, String cur, int left, int right, int n) {
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }
        if (left < n) {
            backtrack(ans, cur + "(", left + 1, right, n);
        }
        if (right < left) {
            backtrack(ans, cur + ")", left, right + 1, n);
        }
    }

}

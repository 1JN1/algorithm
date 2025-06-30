package day_10;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/9/15
 * @description 括号生成
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(generateParenthesis(3));
    }

//    public List<String> generateParenthesis(int n) {
//
//        // n为1时的状态
//        List<String> res = Collections.singletonList("()");
//
//        HashMap<String, Boolean> map = new HashMap<>();
//
//        map.put("()", true);
//
//        for (int i = 1; i < n; i++) {
//
//            List<String> temp = new ArrayList<>();
//
//            for (String str : res) {
//
//                String tempStr;
//
//                for (int j = 0; j < str.length(); j++) {
//                    tempStr = str.substring(0, j) + "()" + str.substring(j);
//                    if (!map.containsKey(tempStr) || !map.get(tempStr)) {
//                        temp.add(tempStr);
//                        map.put(tempStr, true);
//                    }
//                }
//
//            }
//
//            res = temp;
//
//        }
//
//        return res;
//    }


    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {

        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        // 右括号数不能超过左括号数
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

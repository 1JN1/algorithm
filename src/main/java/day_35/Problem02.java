package day_35;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/25
 * @description 分割回文串
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(partition("efe"));

    }

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();

        partitionHelper(s, 0, res, path);

        return res;
    }

    public void partitionHelper(String s, int begin, List<List<String>> res, List<String> path) {

        if (begin == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = begin; i < s.length(); i++) {

            String str = s.substring(begin, i + 1);

            if (!isHuiWen(str)) {
                continue;
            }

            path.add(str);

            partitionHelper(s, i + 1, res, path);

            path.remove(path.size() - 1);

        }

    }

    public boolean isHuiWen(String str) {

        int n = str.length();

        for (int i = 0; i <= n / 2; i++) {

            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                return false;
            }

        }

        return true;
    }

}

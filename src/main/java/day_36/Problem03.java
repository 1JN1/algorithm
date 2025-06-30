package day_36;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 王文涛
 * @date 2024/10/26
 * @description 单词拆分
 **/
public class Problem03 {

    @Test
    public void test() {


        String s = "abcd";
        List<String> list = Arrays.asList("a", "abc", "b", "cd");

        System.out.println(wordBreak(s, list));

    }

    public boolean wordBreak(String s, List<String> wordDict) {


        for (String word : wordDict) {

            if (!s.contains(word)) {
                continue;
            }

            String[] strings = s.split(word);

            int i = 0, n = strings.length;

            for (; i < n; i++) {

                if (strings[i].isEmpty()) {
                    continue;
                }

                if (!wordBreak(strings[i], wordDict)) {
                    break;
                }

            }

            if (i == n) {
                return true;
            }
        }


        return false;
    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[s.length()];
    }

}

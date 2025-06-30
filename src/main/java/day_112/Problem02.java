package day_112;

import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/3/20
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

    }

    public int lengthLongestPath(String input) {

        int n = input.length();

        int idx = 0;

        int ans = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        while (idx < n) {

            int depth = 1;

            // 每存在一个\t，depth+1
            while (idx < n && input.charAt(idx) == '\t') {
                depth++;
                idx++;
            }

            // 统计当前目录或字符的长度
            boolean isFile = false;
            int len = 0;
            while (idx < n && input.charAt(idx) != '\n') {
                if (input.charAt(idx) == '.') {
                    isFile = true;
                }
                len++;
                idx++;
            }

            // 跳过 \n
            idx++;

            // 来到了同级的下一个目录
            while (stack.size() >= depth) {
                // 上一个目录中的内容已经访问完了
                stack.pop();
            }

            // 如果有上级目录，累加上级目录的长度
            if (!stack.isEmpty()) {
                // +1 意味着 '/' 这个符号的长度
                len += stack.peek() + 1;
            }

            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }

        }

        return ans;
    }

}

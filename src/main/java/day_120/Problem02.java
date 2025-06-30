package day_120;

import day_29.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/4/14
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(
                new Integer[]{1, 1, 1, null, 1, null, null, 1, 1, null, 1}
        );

        System.out.println(longestZigZag2(root));
    }


    public int longestZigZag(TreeNode root) {

        return traversal(root);
    }

    public int traversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int ans = 0;

        int left = dfs(node.left, 0, 1);
        int right = dfs(node.right, 1, 1);

        ans = Math.max(ans, Math.max(left, right));

        ans = Math.max(ans, traversal(node.left));
        ans = Math.max(ans, traversal(node.right));

        return ans;
    }

    public int dfs(TreeNode node, int direction, int depth) {
        if (node == null) {
            return depth - 1;
        }

        // 现在的方向为左
        if (direction == 0) {
            return dfs(node.right, 1, depth + 1);
        } else {
            return dfs(node.left, 0, depth + 1);
        }
    }

    int max;

    public int longestZigZag2(TreeNode root) {
        max = 0;
        dfs2(root);
        return max;
    }

    private int[] dfs2(TreeNode node) {
        if (node == null) {
            // [left, right]
            return new int[]{-1, -1};
        }

        int[] left = dfs2(node.left);
        int[] right = dfs2(node.right);

        // 当前节点作为左子节点时的最长路径（父节点来自右边）
        int currentLeft = left[1] + 1;
        // 当前节点作为右子节点时的最长路径（父节点来自左边）
        int currentRight = right[0] + 1;

        // 更新全局最大值
        max = Math.max(max, Math.max(currentLeft, currentRight));

        // 返回当前节点作为左子节点和右子节点的最长路径
        return new int[]{currentLeft, currentRight};
    }

}

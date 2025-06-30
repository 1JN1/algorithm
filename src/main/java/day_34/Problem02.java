package day_34;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/23
 * @description 求根节点到叶节点数字之和
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{6, 8, -1, 7, 3, -1, 8, -1, -1});


        System.out.println(sumNumbers(tree));

    }

    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {

        if (root == null) {
            return 0;
        }

        int sum = preSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

}

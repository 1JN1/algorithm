package day_32;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/20
 * @description 路径总和
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        return hasPathHelper(root, 0, targetSum);
    }

    public boolean hasPathHelper(TreeNode root, int sum, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            return true;
        }

        return hasPathHelper(root.left, sum + root.val, targetSum) || hasPathHelper(root.right, sum + root.val, targetSum);
    }

}

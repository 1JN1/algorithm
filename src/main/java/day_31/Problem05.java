package day_31;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/19
 * @description 二叉树的最小深度
 **/
public class Problem05 {

    @Test
    public void test() {


    }

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0) {
            return 1 + right;
        }

        if (right == 0) {
            return 1 + left;
        }

        return Math.min(left, right) + 1;
    }

}

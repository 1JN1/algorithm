package day_72;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/18
 * @description
 **/
public class Problem01 {

    @Test
    public void test() {

    }

    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeaversHelper(root, false);
    }

    public int sumOfLeftLeaversHelper(TreeNode root, boolean flag) {

        if (root == null) {
            return 0;
        }

        // 是左叶子
        if (root.left == null && root.right == null && flag) {
            return root.val;
        }

        return sumOfLeftLeaversHelper(root.left, true) + sumOfLeftLeaversHelper(root.right, false);
    }

}

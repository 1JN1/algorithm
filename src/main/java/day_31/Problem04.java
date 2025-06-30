package day_31;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/19
 * @description 平衡二叉树
 **/
public class Problem04 {

    @Test
    public void test() {


    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int left = getHigh(root.left);
        int right = getHigh(root.right);

        if (Math.abs(left - right) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int getHigh(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = getHigh(root.left);
        int right = getHigh(root.right);

        return Math.max(left, right) + 1;
    }

}

package day_29;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/15
 * @description 验证二叉搜索树
 **/
public class Problem04 {

    @Test
    public void test() {

        int[] pre = {5, 4, 6, 3, 7};
        int[] in = {4, 5, 3, 6, 7};

        TreeNode tree = TreeNode.buildTree(pre, in);

        System.out.println(isValidBST(tree));

    }

    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTHelper(TreeNode root, long min, long max) {

        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }

}

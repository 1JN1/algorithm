package day_30;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/16
 * @description 对称二叉树
 **/
public class Problem01 {

    @Test
    public void test() {

        int[] pre = {1, 2, 5, 4, 2, 4, 3};
        int[] in = {5, 2, 4, 1, 4, 2, 3};

        TreeNode tree = TreeNode.buildTree(pre, in);

        System.out.println(isSymmetric(tree));

    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return isSymmetricHelper(node1.left, node2.right) && isSymmetricHelper(node1.right, node2.left);
    }

}

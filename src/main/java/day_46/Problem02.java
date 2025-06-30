package day_46;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/11
 * @description 翻转二叉树
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, -1, -1, 4, 5});

        TreeNode tree = invertTree(root);

        TreeNode.printTree(tree);

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;

        return root;
    }

}

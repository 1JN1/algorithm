package day_30;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/16
 * @description 从前序和中序序列构造二叉树
 **/
public class Problem05 {

    @Test
    public void test() {

        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};

        TreeNode tree = buildTree(pre, in);

        TreeNode.printTree(tree);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {

        if (pl <= pr && il <= ir) {
            int nodeVal = preorder[pl];
            TreeNode node = new TreeNode(nodeVal);

            int len = 0;

            for (int i = il; i <= ir; i++) {
                if (inorder[i] == nodeVal) {
                    break;
                }
                len++;
            }

            node.left = buildTreeHelper(preorder, pl + 1, pl + len, inorder, il, il + len - 1);
            node.right = buildTreeHelper(preorder, pl + len + 1, pr, inorder, il + len + 1, ir);

            return node;
        }

        return null;
    }

}

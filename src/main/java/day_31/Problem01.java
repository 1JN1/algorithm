package day_31;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/19
 * @description 根据中序和后序序列构造二叉树
 **/
public class Problem01 {


    @Test
    public void test() {

        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};

        TreeNode tree = buildTree(in, post);

        TreeNode.printTree(tree);

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {

        if (il > ir || pl > pr) {
            return null;
        }

        // 当前节点值
        int val = postorder[pr];
        TreeNode node = new TreeNode(val);

        int len = 0;

        for (int i = il; i <= ir; i++) {
            if (inorder[i] == val) {
                break;
            }
            len++;
        }

        node.left = buildTreeHelper(inorder, il, il + len - 1, postorder, pl, pl + len - 1);
        node.right = buildTreeHelper(inorder, il + len + 1, ir, postorder, pl + len, pr - 1);

        return node;
    }

}

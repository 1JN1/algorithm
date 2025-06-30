package day_51;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/16
 * @description 二叉搜索树中的中序后继
 **/
public class Problem01 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel(new int[]{5, 3, 6, 2, 4, -1, -1, 1});
        TreeNode p = root.left;

        System.out.println(inorderSuccessor(root, p));

    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode ans = null;

        while (root != null) {

            if (root.val > p.val) {
                ans = root;
                root = root.left;
            }else{
                root = root.right;
            }

        }

        return ans;
    }

}

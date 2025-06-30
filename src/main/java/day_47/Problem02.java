package day_47;

import day_09.ListNode;
import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/12
 * @description 二叉搜索树的最近公共祖先
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{6, 2, 8, 0, 4, 7, 9, -1, -1, 3, 5});

        TreeNode p = tree.left.right.left;

        TreeNode q = tree.left.right.right;

        TreeNode treeNode = lowestCommonAncestor(tree, p, q);
        System.out.println(treeNode);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val < q.val ? p : q;

        TreeNode node = root;

        while (node != null) {

            if (node.val > max.val) {
                node = node.left;
            } else if (node.val < min.val) {
                node = node.right;
            } else {
                break;
            }

        }

        return node;
    }

}

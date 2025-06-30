package day_155;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/6/7
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{3, 4, 5, 1, null, 2});
        TreeNode subRoot = TreeNode.buildTreeByLevel2(new Integer[]{3, 1, 2});

        System.out.println(isSubtree(root, subRoot));
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}

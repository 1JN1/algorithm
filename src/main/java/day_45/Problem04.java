package day_45;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/11/10
 * @description 完全二叉树的节点个数
 **/
public class Problem04 {

    @Test
    public void test() {


        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, 4, 5, 6, -1});

        System.out.println(countNodes(tree));
        System.out.println(countNodes2(tree));

    }

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }


        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int h = 0;

        TreeNode node = root;

        while (node.left != null) {
            h++;
            node = node.left;
        }


        int left = 1 << h, right = (1 << (h + 1)) - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (exist(root, mid, h)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return right;
    }

    public boolean exist(TreeNode root, int target, int h) {

        if (root == null) {
            return false;
        }

        for (int i = 0; i < h; i++) {

            int num = target & (1 << (h - i - 1));

            if (num != 0) {
                root = root.right;
            } else {
                root = root.left;
            }

            if (root == null) {
                return false;
            }

        }

        return true;
    }

}

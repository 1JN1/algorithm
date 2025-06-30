package day_77;

import day_29.TreeNode;
import org.junit.Test;

/**
 * @author 王文涛
 * @date 2025/1/24
 * @description 删除二叉搜索树中的节点
 **/
public class Problem03 {

    @Test
    public void test() {

        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{5, 1, 6, 0, 3, null, 7, null, null, 2, 4});

        root = deleteNode(root, 1);

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {

            // 待删除节点是叶子节点
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 找到后继节点
                TreeNode last = root.right;
                while (last.left != null) {
                    last = last.left;
                }
//                int temp = last.val;
//                // 交换两个节点
//                last.val = root.val;
//                root.val = temp;
//                root.right = deleteNode(root.right, key);
                root.right = deleteNode(root.right, last.val);
                last.left = root.left;
                last.right = root.right;
                return last;
            }

        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

}

package day_29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/10/15
 * @description 二叉树的中序遍历
 **/
public class Problem01 {

    @Test
    public void test() {


        int[] pre = {1, 2, 3, 4, 5};
        int[] in = {2, 1, 4, 5, 3};

        TreeNode root = TreeNode.buildTree(pre, in);

        List<Integer> list = inorderTraversal3(root);

        list.forEach(System.out::println);


    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();

        inorderHelper(root, ans);

        return ans;
    }

    public void inorderHelper(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        inorderHelper(root.left, ans);
        ans.add(root.val);
        inorderHelper(root.right, ans);

    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {

            // 左子树一路入栈
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {

                root = stack.pop();
                ans.add(root.val);
                root = root.right;

            }

        }

        return ans;
    }

    /**
     * Morris 遍历算法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal3(TreeNode root) {

        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;

        while (root != null) {

            // 左子树为空
            if (root.left == null) {

                ans.add(root.val);
                root = root.right;

            } else {

                pre = root.left;

                // 找到左子树中最右的节点
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }

                if (pre.right == null) {

                    pre.right = root;
                    root = root.left;

                } else {

                    pre.right = null;
                    ans.add(root.val);
                    root = root.right;

                }

            }

        }

        return ans;
    }

}

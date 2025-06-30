package day_37;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/10/31
 * @description 二叉树的后序遍历
 **/
public class Problem03 {

    @Test
    public void test() {

        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, 6, 7, 4, 5});
        System.out.println(postorderTraversal(tree));

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;


        while (root != null || !stack.isEmpty()) {

            // 左子树一路入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            if (root.right != null && root.right != last) {
                root = root.right;
            } else {

                root = stack.pop();
                last = root;
                ans.add(root.val);
                root = null;

            }

        }

        return ans;
    }

}

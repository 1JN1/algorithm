package day_37;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 王文涛
 * @date 2024/10/31
 * @description 二叉树的前序遍历
 **/
public class Problem02 {

    @Test
    public void test() {

        TreeNode tree = TreeNode.buildTreeByLevel(new int[]{1, 2, 3, 6, 7, 4, 5});

        List<Integer> list = preorderTraversal(tree);
        System.out.println(list);

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return ans;
    }

}

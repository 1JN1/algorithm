package day_31;

import day_29.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/10/19
 * @description 二叉树的层序遍历II
 **/
public class Problem02 {

    @Test
    public void test() {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();


        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(0, list);

        }

        return ans;
    }

}

package day_170;

import day_29.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2025/7/8
 * @description
 **/
public class Problem02 {

    @Test
    public void test() {
        TreeNode root = TreeNode.buildTreeByLevel2(
                new Integer[]{8, 17, 21, 18, null, null, 6}
        );

        System.out.println(decorateRecord(root));
    }

    public List<List<Integer>> decorateRecord(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> level = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        // 方向，false表示从左到右
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 从左向右
            if (!flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollFirst();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }

            flag = !flag;
            res.add(level);
            level = new ArrayList<>();
        }

        return res;
    }

}

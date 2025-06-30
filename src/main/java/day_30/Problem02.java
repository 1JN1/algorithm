package day_30;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 王文涛
 * @date 2024/10/16
 * @description 二叉树的层序遍历
 **/
public class Problem02 {


    @Test
    public void test() {

        int[] level = {3, 9, 20, 5, 6, 15, 7, -1, -1, -1, -1, -1, -1, -1, -1};

        TreeNode tree = TreeNode.buildTreeByLevel(level);

        List<List<Integer>> lists = levelOrder(tree);

        lists.forEach(System.out::println);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // 模拟队列
        TreeNode[] queue = new TreeNode[2001];
        int rear = -1, front = -1;

        queue[++rear] = root;

        // 队列不为空
        while (front < rear) {

            int right = rear;
            while (front != right) {

                TreeNode node = queue[++front];
                level.add(node.val);

                if (node.left != null) {
                    queue[++rear] = node.left;
                }
                if (node.right != null) {
                    queue[++rear] = node.right;
                }

            }

            res.add(new ArrayList<>(level));
            level.clear();


        }

        return res;
    }

}

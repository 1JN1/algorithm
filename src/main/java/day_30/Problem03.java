package day_30;

import day_29.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author 王文涛
 * @date 2024/10/16
 * @description 二叉树的锯齿形层序遍历
 **/
public class Problem03 {

    @Test
    public void test() {

        int[] level = {3, 9, 20, 5, 6, 15, 7, -1, -1, -1, -1, -1, -1, -1, -1};

        TreeNode tree = TreeNode.buildTreeByLevel(level);

        List<List<Integer>> lists = zigzagLevelOrder(tree);

        lists.forEach(System.out::println);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode[] queue = new TreeNode[2001];
        int rear = -1, front = -1;

        queue[++rear] = root;

        // 方向，初始朝右
        boolean left = true;


        while (front < rear) {

            int size = rear - front;
            int right = rear;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue[right--];
                front++;
                level.add(node.val);

                // 先进左，再进右
                if (left) {

                    if (node.left != null) {
                        queue[++rear] = node.left;
                    }

                    if (node.right != null) {
                        queue[++rear] = node.right;
                    }

                } else {

                    if (node.right != null) {
                        queue[++rear] = node.right;
                    }

                    if (node.left != null) {
                        queue[++rear] = node.left;
                    }

                }


            }

            // 更改方向
            left = !left;
            result.add(new ArrayList<>(level));
            level.clear();

        }

        return result;
    }

}

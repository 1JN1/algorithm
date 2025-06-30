package day_32;

import day_29.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/20
 * @description 路径总和II
 **/
public class Problem02 {

    @Test
    public void test() {

        int[] pre = {5, 4, 11, 7, 2, 8, 13, 4, 5, 1};
        int[] in = {7, 11, 2, 4, 5, 13, 8, 5, 4, 1};

        TreeNode tree = TreeNode.buildTree(pre, in);

        System.out.println(pathSum(tree, 22));

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        pathSumHelper(root, targetSum, res, path);

        return res;
    }

    public void pathSumHelper(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {

        if (root == null) {
            return;
        }

        path.add(root.val);

        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                res.add(new ArrayList<>(path));
            }
        }

        pathSumHelper(root.left, targetSum - root.val, res, path);

        pathSumHelper(root.right, targetSum - root.val, res, path);
        path.remove(path.size() - 1);
    }

}

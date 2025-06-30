package day_76;

import day_29.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王文涛
 * @date 2025/1/23
 * @description 路径总和 III
 **/
public class Problem01 {

    @Test
    public void test() {


        TreeNode root = TreeNode.buildTreeByLevel2(new Integer[]{1000000000, 1000000000, null, 294967296, null, 1000000000, null, 1000000000, null, 1000000000});

        System.out.println(pathSum2(root, 0));

    }

    int num = 0;

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        pathSumHelper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return num;
    }

    public void pathSumHelper(TreeNode root, long targetSum) {

        if (root == null || (root.left == null && root.right == null && root.val != targetSum)) {
            return;
        }

        if (root.val == targetSum) {
            num++;
        }


        pathSumHelper(root.left, targetSum - root.val);
        pathSumHelper(root.right, targetSum - root.val);
    }

    public int pathSum2(TreeNode root, int targetSum) {

        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);

        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int target) {

        if (root == null) {
            return 0;
        }

        // 根节点到当前节点的前缀和
        curr += root.val;
        // 根节点到路径上某节点前缀和为curr-target的数目
        int ret = prefix.getOrDefault(curr - target, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, target);
        ret += dfs(root.right, prefix, curr, target);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}

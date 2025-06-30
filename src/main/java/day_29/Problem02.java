package day_29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王文涛
 * @date 2024/10/15
 * @description 不同的二叉搜索树II
 **/
public class Problem02 {

    @Test
    public void test() {

        List<TreeNode> list = generateTrees(3);

    }

    public List<TreeNode> generateTrees(int n) {

        return generateTreesHelper(1, n);

    }

    public List<TreeNode> generateTreesHelper(int start, int end) {

        List<TreeNode> allTrees = new ArrayList<>();

        if (start > end) {

            allTrees.add(null);

            return allTrees;
        }

        for (int i = start; i <= end; i++) {

            // 左子树集合
            List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);

            // 右子树集合
            List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);
                }
            }

        }

        return allTrees;
    }

}

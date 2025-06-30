package day_29;

import org.junit.Test;

/**
 * @author 王文涛
 * @date 2024/10/15
 * @description 相同的树
 **/
public class Problem05 {

    @Test
    public void test() {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}

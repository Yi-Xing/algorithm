package 力扣.普通题.简单.SerialNumber235;

import 力扣.普通题.困难.SerialNumber968.Solution1;

/**
 * @date 2020-09-17
 */
public class Solution {

    TreeNode root = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        try {
            dfs(root, p, q);
        } catch (Exception ignored) {
        }
        return this.root;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) throws Exception {
        if (root == null) {
            return false;
        }
        boolean is = false;
        if (root == p || root == q) {
            is = true;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if (left || right) {
            if (is) {
                this.root = root;
                throw new Exception();
            } else {
                is = true;
            }
            if (left && right) {
                this.root = root;
                throw new Exception();
            }
        }
        return is;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}




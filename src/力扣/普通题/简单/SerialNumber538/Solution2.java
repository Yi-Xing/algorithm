package 力扣.普通题.简单.SerialNumber538;

import java.util.LinkedList;
import java.util.List;

/**
 * @date 2020-09-21
 */
public class Solution2 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
        }
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

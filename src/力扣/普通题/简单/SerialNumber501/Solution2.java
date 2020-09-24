package 力扣.普通题.简单.SerialNumber501;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-24
 */
public class Solution2 {

    int preVal = 0;
    int max = 1;
    int count = 1;
    List<Integer> result = new ArrayList<>();


    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] arrayResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arrayResult[i] = result.get(i);
        }
        return arrayResult;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (preVal == root.val) {
            count++;
        } else {
            preVal = root.val;
            count = 1;
        }
        if (max < count) {
            max = count;
            result.clear();
            result.add(root.val);
        } else if (max == count) {
            result.add(root.val);
        }
        dfs(root.right);
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

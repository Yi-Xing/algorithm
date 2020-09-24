package 力扣.普通题.简单.SerialNumber501;

import java.util.*;

/**
 * @date 2020-09-24
 */
public class Solution1 {


    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        int tmp = 0;
        int max = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (Integer value : list) {
            if (tmp == value) {
                count++;
            } else {
                tmp = value;
                count = 1;
            }
            if (max < count) {
                max = count;
                result.clear();
                result.add(value);
            } else if (max == count) {
                result.add(value);
            }
        }
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
        list.add(root.val);
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

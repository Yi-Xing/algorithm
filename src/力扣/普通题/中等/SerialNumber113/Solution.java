package 力扣.普通题.中等.SerialNumber113;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-14
 */
public class Solution {

    int sum = 0;

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        dfs(root, new ArrayList<>(), 0);
        return lists;
    }

    public void dfs(TreeNode root, List<Integer> list, int count) {
        if (root == null) {
            return;
        }
        // 添加当前节点
        list.add(root.val);
        count += root.val;
        // 如果当前节点为子节点，则判断是否合法
        if (root.left == null && root.right == null) {
            if (count == sum) {
                lists.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        // 向左右子树递归
        dfs(root.left, list, count);
        dfs(root.right, list, count);
        // 回溯，删除当前节点
        list.remove(list.size() - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

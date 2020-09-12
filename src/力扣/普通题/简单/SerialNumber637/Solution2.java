package 力扣.普通题.简单.SerialNumber637;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-12
 */
public class Solution2 {

    public List<Double> averageOfLevels(Solution1.TreeNode root) {
        List<Solution1.TreeNode> list = new ArrayList<>();
        list.add(root);
        List<Double> ret = new ArrayList<>();
        bfs(ret, list);
        return ret;
    }

    public void bfs(List<Double> ret, List<Solution1.TreeNode> parent) {
        if (parent.isEmpty()) {
            return;
        }
        // 记录所有子节点
        List<Solution1.TreeNode> temp = new ArrayList<>();
        double sum = 0, count = 0;
        for (Solution1.TreeNode node : parent) {
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
            sum += node.val;
            count++;
        }
        ret.add(sum / count);
        // 继续广度查询下一级
        bfs(ret, temp);
    }

    public class TreeNode {
        int val;
        Solution1.TreeNode left;
        Solution1.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

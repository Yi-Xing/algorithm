package 力扣.普通题.中等.SerialNumber77;

import java.util.*;

/**
 * @date 2020-09-08
 */
class Solution {

    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    /**
     * @param c 代表当前使用的数
     */
    public void dfs(int c, int n, int k) {
        if (temp.size() + n - c + 1 < k) {
            return;
        }
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 将当前数加入集合中
        temp.add(c);
        // 使用当前数向后递归
        dfs(c+1, n, k);
        // 删除将才添加的数
        temp.remove(temp.size()-1);
        // 不使用当前数向后递归
        dfs(c+1, n, k);
    }
}

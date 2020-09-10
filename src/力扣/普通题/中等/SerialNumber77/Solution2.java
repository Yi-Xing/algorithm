package 力扣.普通题.中等.SerialNumber77;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-08
 */
public class Solution2 {

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(temp,ans,1, n, k);
        return ans;
    }

    /**
     * @param number 代表当前使用的数
     */
    public void dfs(List<Integer> temp, List<List<Integer>> ans, int number, int n, int k) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (; temp.size() + n - number + 1 >= k; number++) {
            // 将当前数加入集合中
            temp.add(number);
            // 向后递归
            dfs(temp,ans,number + 1, n, k);
            // 删除将才添加的数
            temp.remove(temp.size() - 1);
        }
    }
}

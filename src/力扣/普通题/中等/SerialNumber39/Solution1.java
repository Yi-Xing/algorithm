package 力扣.普通题.中等.SerialNumber39;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @date 2020-09-09
 */
public class Solution1 {


    /**
     * 递归，自己的第一写法
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, 0, candidates, target, temp, ans);
        return ans;
    }

    /**
     * @param sum   当前组成的和
     * @param index 当前使用的下标
     */
    public void dfs(int sum, int index, int[] candidates, int target, List<Integer> temp, List<List<Integer>> ans) {
        // 如何当前求和大于系统要求的值 或 数组中的数已使用完 则结束递归
        if (sum > target || index == candidates.length) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 加入当前的数
        temp.add(candidates[index]);
        // 使用当前数，继续使用当前数
        dfs(sum + candidates[index], index, candidates, target, temp, ans);
        // 回溯不使用当前数
        temp.remove(temp.size() - 1);
        dfs(sum, index + 1, candidates, target, temp, ans);
    }
}

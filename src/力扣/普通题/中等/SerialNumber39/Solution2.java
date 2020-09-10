package 力扣.普通题.中等.SerialNumber39;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-10
 */
public class Solution2 {

    /**
     * 优化
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(temp,ans,0,candidates,target);
        return ans;
    }

    /**
     * @param index 当前使用的数组下标
     * @param target 剩余的值
     */
    public void dfs(List<Integer> temp, List<List<Integer>> ans, int index, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (; index < candidates.length; index++) {
            // 剪枝，如果剩余值小于当前数值则不需要进行递归
            if (target >= candidates[index]) {
                temp.add(candidates[index]);
                dfs(temp,ans,index,candidates,target-candidates[index]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

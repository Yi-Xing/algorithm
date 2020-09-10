package 力扣.普通题.中等.SerialNumber40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @date 2020-09-10
 */
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(temp, ans, 0, candidates, target);
        return ans;
    }

    public void dfs(List<Integer> temp, List<List<Integer>> ans, int index, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length && target >= candidates[i]; i++) {
            // 第二次循环后去重，因为数组中有重复的元素，如果已使用过该元素，则将该元素舍弃
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            dfs(temp, ans, i + 1, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}

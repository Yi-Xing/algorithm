package 力扣.普通题.中等.SerialNumber78;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-20
 */
public class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, new ArrayList<>(), 0, i);
        }
        return lists;
    }

    public void dfs(int[] nums, List<Integer> list, int index, int count) {
        if (count == list.size()) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, list, i + 1, count);
            list.remove(list.size() - 1);
        }
    }
}

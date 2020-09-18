package 力扣.普通题.中等.SerialNumber47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2020-09-18
 */
class Solution {

    /**
     * 存储结果集
     */
    List<List<Integer>> lists = new ArrayList<>();

    /**
     * 存储每一个元素是否已使用过
     */
    boolean[] is;

    public List<List<Integer>> permuteUnique(int[] nums) {
        is = new boolean[nums.length];
        // 排序，将相同的数聚集到一起，方法判重
        Arrays.sort(nums);
        dfs(new ArrayList<>(), nums, 0);
        return lists;
    }

    public void dfs(List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果该元素已被选过则结束循环，或者和前一个元素相同而前一个元素未被选择
            if (is[i] || (i > 0 && nums[i] == nums[i - 1] && !is[i - 1])) {
                continue;
            }
            is[i] = true;
            list.add(nums[i]);
            dfs(list, nums, index + 1);
            is[i] = false;
            list.remove(index);
        }
    }
}

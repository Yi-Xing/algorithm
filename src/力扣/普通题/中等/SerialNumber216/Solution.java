package 力扣.普通题.中等.SerialNumber216;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020-09-11
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        dfs(1, temp, lists, k, n);
        return lists;
    }

    public void dfs(int index, List<Integer> temp, List<List<Integer>> lists, int k, int n) {
        if (n == 0 && k == 0) {
            lists.add(new ArrayList<>(temp));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = index; i < 10; i++) {
            if (n >= i) {
                temp.add(i);
                dfs(i + 1, temp, lists, k - 1, n - i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}

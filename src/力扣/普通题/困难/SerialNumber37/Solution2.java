package 力扣.普通题.困难.SerialNumber37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2020-09-17
 */
public class Solution2 {
    /**
     * 存储每行那些值已被使用
     */
    private boolean[][] line = new boolean[9][9];
    /**
     * 存储每列那些值已被使用
     */
    private boolean[][] column = new boolean[9][9];
    /**
     * 存储每个3宫格那些值已被使用
     */
    private boolean[][][] block = new boolean[3][3][9];
    /**
     * 是否找到了答案
     */
    private boolean valid = false;
    /**
     * 存储还要哪些位置没有填
     */
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // 首先变量数组，为成员变量赋初值
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // 为空则添加到集合中
                    spaces.add(new int[]{i, j});
                } else {
                    int temp = board[i][j] - '1';
                    // 存在个更改数组的值
                    line[i][temp] = column[j][temp] = block[i / 3][j / 3][temp] = true;
                }
            }
        }
        dfs(board, 0);
    }


    public void dfs(char[][] board, int index) {
        if (index == spaces.size()) {
            valid = true;
            return;
        }
        int[] subscript = spaces.get(index);
        int a = subscript[0];
        int b = subscript[1];
        for (int i = 0; i < 9 && !valid; i++) {
            // 判断该数是否可用
            if (!line[a][i] && !column[b][i] && !block[a / 3][b / 3][i]) {
                line[a][i] = column[b][i] = block[a / 3][b / 3][i] = true;
                board[a][b] = (char) ('1' + i);
                // 向后递归
                dfs(board, index + 1);
                // 回溯
                line[a][i] = column[b][i] = block[a / 3][b / 3][i] = false;
            }
        }
    }
}



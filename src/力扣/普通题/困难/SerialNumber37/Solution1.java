package 力扣.普通题.困难.SerialNumber37;

import java.util.Arrays;

/**
 * @date 2020-09-15
 */
public class Solution1 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    /**
     * table 就是存储数独元素的二维数组，x表示行，y表示列，xy确定指针的位置
     */
    private void dfs(char[][] table, int x, int y) {
        if (x == 8 && y == 8) {
            return;
        }
        // 如果该地方没有数，则开始执行
        if (table[x][y] == '.') {
            for (int i = 1; i < 10; i++) {
                // 判断当前位置是否可以存放该数
                if (check(table, x, y, (char) ('0' + i))) {
                    table[x][y] = (char) ('0' + i);
                    break;
                }
            }
        }
        if (x != 8) {
            dfs(table, x + 1, y);
        }

    }

    private boolean check(char[][] table, int x, int y, char temp) {
        // 判断当前行是否可以存放
        for (int i = 0; i < 9; i++) {
            if (table[x][i] == temp) {
                return false;
            }
        }
        // 判断当前列是否可以存放
        for (int i = 0; i < 9; i++) {
            if (table[i][y] == temp) {
                return false;
            }
        }
        // 判断当前的小网格是否可以存放
        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                if (table[i][j] == temp) {
                    return false;
                }
            }
        }
        return true;
    }


}


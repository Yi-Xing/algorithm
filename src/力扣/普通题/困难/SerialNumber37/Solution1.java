package 力扣.普通题.困难.SerialNumber37;

/**
 * @date 2020-09-15
 */
public class Solution1 {


    public void solveSudoku(char[][] board) {
        try {
            dfs(board, 0, 0);
        }catch (Exception ignored){

        }
    }

    /**
     * table 就是存储数独元素的二维数组，x表示行，y表示列，xy确定指针的位置
     */
    private void dfs(char[][] table, int x, int y) throws Exception {
        if (x == 9) {
            throw new Exception();
        }
        // 如果该地方没有数，则开始执行
        if (table[x][y] == '.') {
            for (int i = 1; i < 10; i++) {
                // 判断当前位置是否可以存放该数
                if (check(table, x, y, (char) ('0' + i))) {
                    table[x][y] = (char) ('0' + i);
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);
                }
            }
            // 回溯到上一个状态
            table[x][y]='.';
        } else {
            dfs(table, x + (y + 1) / 9, (y + 1) % 9);
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


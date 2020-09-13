package 力扣.普通题.中等.SerialNumber79;

/**
 * @date 2020-09-13
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        // 记录指定字符是否使用过
        boolean[][] is = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 判断当前数是否可用
                if (board[i][j] == word.charAt(0)) {
                    is[i][j] = true;
                    if (dfs(is, board, i, j, word, 1)) {
                        return true;
                    }
                    is[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(boolean[][] is, char[][] board, int x, int y, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        char temp = word.charAt(index);
        if (x - 1 >= 0 && board[x - 1][y] == temp && !is[x - 1][y]) {
            is[x - 1][y] = true;
            if (dfs(is, board, x - 1, y, word, index + 1)) {
                return true;
            }
            is[x - 1][y] = false;
        }
        if (x + 1 < board.length && board[x + 1][y] == temp && !is[x + 1][y]) {
            is[x + 1][y] = true;
            if (dfs(is, board, x + 1, y, word, index + 1)) {
                return true;
            }
            is[x + 1][y] = false;
        }
        if (y - 1 >= 0 && board[x][y - 1] == temp && !is[x][y - 1]) {
            is[x][y - 1] = true;
            if (dfs(is, board, x, y - 1, word, index + 1)) {
                return true;
            }
            is[x][y - 1] = false;
        }

        if (y + 1 < board[0].length && board[x][y + 1] == temp && !is[x][y + 1]) {
            is[x][y + 1] = true;
            if (dfs(is, board, x, y + 1, word, index + 1)) {
                return true;
            }
            is[x][y + 1] = false;
        }
        return false;
    }
}

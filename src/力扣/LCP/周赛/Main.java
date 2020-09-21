package 力扣.LCP.周赛;

/**
 * @date 2020-09-13
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if(i==1)
                    if (dfs(mat, i, j)) {
                        System.out.println(i + "    " + j);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] mat, int a, int b) {
        int shang = a - 1;
        int xia = a + 1;
        int zuo = b - 1;
        int you = b + 1;
        while (shang >= 0) {
            if (mat[shang][b] == 1) {
                return false;
            }
            shang--;
        }
        while (xia < mat.length) {
            if (mat[xia][b] == 1) {
                return false;
            }
            xia++;
        }
        while (you < mat[0].length) {
            if (mat[a][you] == 1) {
                return false;
            }
            you++;
        }
        while (zuo >= 0) {
            if (mat[a][zuo] == 1) {
                return false;
            }
            zuo--;
        }
        return true;
    }
}

package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/17 9:40
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] left = new int[n + 1][m + 1];
        int[][] up = new int[n + 1][m + 1];
        int maxBorder = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    int curBorder = Math.min(left[i][j], up[i][j]);
                    while (curBorder > left[i - curBorder + 1][j]
                            || curBorder > up[i][j - curBorder + 1]) {
                        curBorder--;
                    }
                    maxBorder = Math.max(maxBorder, curBorder);
                }
            }
        }
        return maxBorder * maxBorder;
    }
}

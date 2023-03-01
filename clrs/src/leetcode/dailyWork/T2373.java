package leetcode.dailyWork;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/3/1 10:11
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ret = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        ret[i][j] = Math.max(ret[i][j], grid[k][l]);
                    }
                }
            }
        }
        return ret;
    }
}

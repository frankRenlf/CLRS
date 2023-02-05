package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2023/2/5 16:42
 * @Email : sc19lr@leeds.ac.uk
 * @github : <a href="https://github.com/frankRenlf">...</a>
 * @Description :
 */
public class T1210 {

    private static final int[][] DIRS = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

    public int minimumMoves(int[][] g) {
        int n = g.length;
        boolean[][][] vis = new boolean[n][n][2];
        List<int[]> q = new ArrayList<int[]>();
        vis[0][0][0] = true;
        q.add(new int[]{0, 0, 0}); // 初始位置
        for (int step = 1; !q.isEmpty(); ++step) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] t : tmp) {
                for (int[] d : DIRS) {
                    int x = t[0] + d[0], y = t[1] + d[1], s = t[2] ^ d[2];
                    int x2 = x + s, y2 = y + (s ^ 1); // 蛇头
                    if (x2 < n && y2 < n && !vis[x][y][s] &&
                            g[x][y] == 0 && g[x2][y2] == 0 && (d[2] == 0 || g[x + 1][y + 1] == 0)) {
                        if (x == n - 1 && y == n - 2) return step; // 此时蛇头一定在 (n-1,n-1)
                        vis[x][y][s] = true;
                        q.add(new int[]{x, y, s});
                    }
                }
            }
        }
        return -1;
    }

}

package leetcode.stage3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.stage3
 * @createTime : 2022/9/18 12:59
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class Day7 {

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        int[][] sign = new int[row][col];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && sign[i][j] == 0) {
                    int key = i * row + j + 1;
                    int val = calArea(grid, i, j, key, sign);
                    map.put(key, val);
                    max = Math.max(val, max);
                }
            }
        }
        int ret = max;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int tmp = 1;
                    Set<Integer> set = new HashSet<>();
                    for (int x = 0; x < 4; x++) {
                        int nx = i + d[x], ny = j + d[x + 1];
                        if (!isValid(grid, nx, ny) || sign[nx][ny] == 0 || set.contains(sign[nx][ny])) {
                            continue;
                        }
                        tmp += map.get(sign[nx][ny]);
                        set.add(sign[nx][ny]);
                    }
                    ret = Math.max(ret, tmp);
                }
            }
        }
        return ret;
    }

    static int[] d = {0, -1, 0, 1, 0};

    private int calArea(int[][] grid, int i, int j, int key, int[][] sign) {
        int ret = 1;
        sign[i][j] = key;
        for (int x = 0; x < 4; x++) {
            int nx = i + d[x], ny = j + d[x + 1];
            if (isValid(grid, nx, ny) && grid[nx][ny] == 1 && sign[nx][ny] == 0) {
                ret += calArea(grid, nx, ny, key, sign);
            }
        }
        return ret;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }

}

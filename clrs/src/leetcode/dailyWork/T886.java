package leetcode.dailyWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : CLRS
 * @Package : leetcode.dailyWork
 * @createTime : 2022/10/16 14:58
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
public class T886 {


    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<Integer>[] g = new List[n + 1];
        for (int i = 0; i <= n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }
        for (int i = 1; i <= n; ++i) {
            if (color[i] == 0 && !dfs(i, 1, color, g)) {
                return false;
            }
        }
        System.out.println(Arrays.toString(color));
        return true;
    }

    public boolean dfs(int curnode, int nowcolor, int[] color, List<Integer>[] g) {
        color[curnode] = nowcolor;
        for (int nextnode : g[curnode]) {
            if (color[nextnode] != 0 && color[nextnode] == color[curnode]) {
                return false;
            }
            if (color[nextnode] == 0 && !dfs(nextnode, 3 - nowcolor, color, g)) {
                return false;
            }
        }
        return true;
    }

    static T886 t886 = new T886();

    public static void main(String[] args) {
        System.out.println(t886.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
    }


}
